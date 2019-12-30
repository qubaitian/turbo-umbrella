package com.qbt.template.test;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qbt.template.mock.SimpleReflect;
import com.yhhl.ebo.commom.persistence.Page;
import com.yhhl.ebo.commom.persistence.PageRequest;
import com.yhhl.ebo.commom.persistence.Repository;
import com.yhhl.ebo.commom.persistence.Specification;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@org.springframework.stereotype.Repository
public class FootballPoRepository implements Repository<Football> {

    @Autowired
    private FootballPoDao footballPoDao;

    @Autowired
    private FootballPoUtil footballPoUtil;

    @Override
    public void add(Football football) {
        FootballPo footballPo = footballPoUtil.toPo(football);
        footballPoDao.add(footballPo);
        SimpleReflect.setter(football, "id", footballPo.getId());
    }

    @Override
    public void update(Football football) {
        FootballPo footballPo = footballPoUtil.toPo(football);
        footballPoDao.update(footballPo);
    }

    @Override
    public void delete(Football football) {
        FootballPo footballPo = footballPoUtil.toPo(football);
        footballPoDao.delete(footballPo);
    }

    @Override
    public Football findById(Long id) {
        FootballPo footballPo = footballPoDao.findById(id);
        Football football = footballPoUtil.toEntity(footballPo);
        return football;
    }

    @Override
    public List<Football> findAll(Specification specification) {
        List<FootballPo> list = footballPoDao.findAll((FootballSpecification) specification);
        return footballPoUtil.toEntityList(list);
    }

    @Override
    public Page<Football> findAll(Specification specification, PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.pageNumber(), pageRequest.pageSize());
        List<FootballPo> list = footballPoDao.findAll((FootballSpecification) specification);
        PageInfo<FootballPo> pageInfo = new PageInfo<>(list);
        long total = pageInfo.getTotal();
        return Page.of(total, footballPoUtil.toEntityList(list));
    }

}
