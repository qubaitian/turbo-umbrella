package com.qbt.demo.file;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qbt.demo.method.SimpleReflect;
import com.yhhl.ebo.commom.persistence.Page;
import com.yhhl.ebo.commom.persistence.PageRequest;
import com.yhhl.ebo.commom.persistence.Repository;
import com.yhhl.ebo.commom.persistence.Specification;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@org.springframework.stereotype.Repository
public class ApplePoRepository implements Repository<Apple> {

    @Autowired
    private ApplePoDao applePoDao;

    @Override
    public void add(Apple apple) {
        ApplePo applePo = ApplePoUtil.toPo(apple);
        applePoDao.add(applePo);
        SimpleReflect.setter(apple, "id", applePo.getId());
    }

    @Override
    public void update(Apple apple) {
        ApplePo applePo = ApplePoUtil.toPo(apple);
        applePoDao.update(applePo);
    }

    @Override
    public void delete(Apple apple) {
        ApplePo applePo = ApplePoUtil.toPo(apple);
        applePoDao.delete(applePo);
    }

    @Override
    public Apple findById(Long id) {
        ApplePo applePo = applePoDao.findById(id);
        Apple apple = ApplePoUtil.toEntity(applePo);
        return apple;
    }

    @Override
    public List<Apple> findAll(Specification specification) {
        List<ApplePo> list = applePoDao.findAll((AppleSpecification) specification);
        return ApplePoUtil.toEntityList(list);
    }

    @Override
    public Page<Apple> findAll(Specification specification, PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.pageNumber(), pageRequest.pageSize());
        List<ApplePo> list = applePoDao.findAll((AppleSpecification) specification);
        PageInfo<ApplePo> pageInfo = new PageInfo<>(list);
        long total = pageInfo.getTotal();
        return Page.of(total, ApplePoUtil.toEntityList(list));
    }

}
