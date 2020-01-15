package com.qbt.template.repository.slim;/*package*/

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yhhl.ebo.commom.persistence.Page;
import com.yhhl.ebo.commom.persistence.PageRequest;
import com.yhhl.ebo.commom.persistence.Repository;
import com.yhhl.ebo.commom.persistence.Specification;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Repository
public class TemplateRepository implements Repository<Template> {
    @Autowired
    TemplateDao templateDao;

    @Override
    public void add(Template template) {
        templateDao.add(template);
    }

    @Override
    public void update(Template template) {
        templateDao.update(template);
    }

    @Override
    public void delete(Template template) {
        templateDao.delete(template);
    }

    @Override
    public Template findById(Long id) {
        return templateDao.findById(id);
    }

    @Override
    public List<Template> findAll(Specification specification) {
        return templateDao.findAll((TemplateSpecification) specification);
    }

    @Override
    public Page<Template> findAll(Specification specification, PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.pageNumber(), pageRequest.pageSize());
        List<Template> all = templateDao.findAll((TemplateSpecification) specification);
        PageInfo<Template> pageInfo = new PageInfo<>(all);
        long total = pageInfo.getTotal();
        return Page.of(total, all);
    }
}
