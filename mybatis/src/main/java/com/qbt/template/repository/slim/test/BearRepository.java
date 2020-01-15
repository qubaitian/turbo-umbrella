package com.qbt.template.repository.slim.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yhhl.ebo.commom.persistence.Page;
import com.yhhl.ebo.commom.persistence.PageRequest;
import com.yhhl.ebo.commom.persistence.Repository;
import com.yhhl.ebo.commom.persistence.Specification;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Repository
public class BearRepository implements Repository<Bear> {
    @Autowired
    BearDao bearDao;

    @Override
    public void add(Bear bear) {
        bearDao.add(bear);
    }

    @Override
    public void update(Bear bear) {
        bearDao.update(bear);
    }

    @Override
    public void delete(Bear bear) {
        bearDao.delete(bear);
    }

    @Override
    public Bear findById(Long id) {
        return bearDao.findById(id);
    }

    @Override
    public List<Bear> findAll(Specification specification) {
        return bearDao.findAll((BearSpecification) specification);
    }

    @Override
    public Page<Bear> findAll(Specification specification, PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.pageNumber(), pageRequest.pageSize());
        List<Bear> all = bearDao.findAll((BearSpecification) specification);
        PageInfo<Bear> pageInfo = new PageInfo<>(all);
        long total = pageInfo.getTotal();
        return Page.of(total, all);
    }
}
