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
public class BearPoRepository implements Repository<Bear> {

    @Autowired
    private BearPoDao bearPoDao;

    @Override
    public void add(Bear bear) {
        BearPo bearPo = BearPoUtil.toPo(bear);
        bearPoDao.add(bearPo);
        SimpleReflect.setter(bear, "id", bearPo.getId());
    }

    @Override
    public void update(Bear bear) {
        BearPo bearPo = BearPoUtil.toPo(bear);
        bearPoDao.update(bearPo);
    }

    @Override
    public void delete(Bear bear) {
        BearPo bearPo = BearPoUtil.toPo(bear);
        bearPoDao.delete(bearPo);
    }

    @Override
    public Bear findById(Long id) {
        BearPo bearPo = bearPoDao.findById(id);
        Bear bear = BearPoUtil.toEntity(bearPo);
        return bear;
    }

    @Override
    public List<Bear> findAll(Specification specification) {
        List<BearPo> list = bearPoDao.findAll((BearSpecification) specification);
        return BearPoUtil.toEntityList(list);
    }

    @Override
    public Page<Bear> findAll(Specification specification, PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.pageNumber(), pageRequest.pageSize());
        List<BearPo> list = bearPoDao.findAll((BearSpecification) specification);
        PageInfo<BearPo> pageInfo = new PageInfo<>(list);
        long total = pageInfo.getTotal();
        return Page.of(total, BearPoUtil.toEntityList(list));
    }

}
