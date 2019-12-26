package com.qbt.test.crud;


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
public class TemplateEntityPoRepository implements Repository<TemplateEntity> {

    @Autowired
    private TemplateEntityPoDao templateEntityPoDao;

    @Autowired
    private TemplateEntityPoUtil templateEntityPoUtil;

    @Override
    public void add(TemplateEntity templateEntity) {
        TemplateEntityPo templateEntityPo = templateEntityPoUtil.toPo(templateEntity);
        templateEntityPoDao.add(templateEntityPo);
        SimpleReflect.setter(templateEntity, "id", templateEntityPo.getId());
    }

    @Override
    public void update(TemplateEntity templateEntity) {
        TemplateEntityPo templateEntityPo = templateEntityPoUtil.toPo(templateEntity);
        templateEntityPoDao.update(templateEntityPo);
    }

    @Override
    public void delete(TemplateEntity templateEntity) {
        TemplateEntityPo templateEntityPo = templateEntityPoUtil.toPo(templateEntity);
        templateEntityPoDao.delete(templateEntityPo);
    }

    @Override
    public TemplateEntity findById(Long id) {
        TemplateEntityPo templateEntityPo = templateEntityPoDao.findById(id);
        TemplateEntity templateEntity = templateEntityPoUtil.toEntity(templateEntityPo);
        return templateEntity;
    }

    @Override
    public List<TemplateEntity> findAll(Specification specification) {
        List<TemplateEntityPo> list = templateEntityPoDao.findAll((TemplateEntitySpecification) specification);
        return templateEntityPoUtil.toEntityList(list);
    }

    @Override
    public Page<TemplateEntity> findAll(Specification specification, PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.pageNumber(), pageRequest.pageSize());
        List<TemplateEntityPo> list = templateEntityPoDao.findAll((TemplateEntitySpecification) specification);
        PageInfo<TemplateEntityPo> pageInfo = new PageInfo<>(list);
        long total = pageInfo.getTotal();
        return Page.of(total, templateEntityPoUtil.toEntityList(list));
    }

}
