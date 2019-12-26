package com.qbt.test.file;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qbt.test.mock.SimpleReflect;
import com.yhhl.ebo.commom.persistence.Page;
import com.yhhl.ebo.commom.persistence.PageRequest;
import com.yhhl.ebo.commom.persistence.Repository;
import com.yhhl.ebo.commom.persistence.Specification;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@org.springframework.stereotype.Repository
public class DearPoRepository implements Repository<Dear> {

    @Autowired
    private DearPoDao dearPoDao;

    @Autowired
    private DearPoUtil dearPoUtil;

    @Override
    public void add(Dear dear) {
        DearPo dearPo = dearPoUtil.toPo(dear);
        dearPoDao.add(dearPo);
        SimpleReflect.setter(dear, "id", dearPo.getId());
    }

    @Override
    public void update(Dear dear) {
        DearPo dearPo = dearPoUtil.toPo(dear);
        dearPoDao.update(dearPo);
    }

    @Override
    public void delete(Dear dear) {
        DearPo dearPo = dearPoUtil.toPo(dear);
        dearPoDao.delete(dearPo);
    }

    @Override
    public Dear findById(Long id) {
        DearPo dearPo = dearPoDao.findById(id);
        Dear dear = dearPoUtil.toEntity(dearPo);
        return dear;
    }

    @Override
    public List<Dear> findAll(Specification specification) {
        List<DearPo> list = dearPoDao.findAll((DearSpecification) specification);
        return dearPoUtil.toEntityList(list);
    }

    @Override
    public Page<Dear> findAll(Specification specification, PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.pageNumber(), pageRequest.pageSize());
        List<DearPo> list = dearPoDao.findAll((DearSpecification) specification);
        PageInfo<DearPo> pageInfo = new PageInfo<>(list);
        long total = pageInfo.getTotal();
        return Page.of(total, dearPoUtil.toEntityList(list));
    }

}
