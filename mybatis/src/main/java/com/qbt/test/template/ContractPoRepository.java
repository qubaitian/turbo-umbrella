package com.qbt.test.template;


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
public class ContractPoRepository implements Repository<TemplateEntity> {

    @Autowired
    private ContractPoDao contractPoDao;

    @Override
    public void add(TemplateEntity templateEntity) {
        ContractPo contractPo = ContractPoUtil.toPo(templateEntity);
        contractPoDao.add(contractPo);
        SimpleReflect.setter(templateEntity, "id", contractPo.getId());
    }

    @Override
    public void update(TemplateEntity templateEntity) {
        ContractPo contractPo = ContractPoUtil.toPo(templateEntity);
        contractPoDao.update(contractPo);
    }

    @Override
    public void delete(TemplateEntity templateEntity) {
        ContractPo contractPo = ContractPoUtil.toPo(templateEntity);
        contractPoDao.delete(contractPo);
    }

    @Override
    public TemplateEntity findById(Long id) {
        ContractPo contractPo = contractPoDao.findById(id);
        TemplateEntity templateEntity = ContractPoUtil.toEntity(contractPo);
        return templateEntity;
    }

    @Override
    public List<TemplateEntity> findAll(Specification specification) {
        List<ContractPo> list = contractPoDao.findAll((ContractSpecification) specification);
        return ContractPoUtil.toEntityList(list);
    }

    @Override
    public Page<TemplateEntity> findAll(Specification specification, PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.pageNumber(), pageRequest.pageSize());
        List<ContractPo> list = contractPoDao.findAll((ContractSpecification) specification);
        PageInfo<ContractPo> pageInfo = new PageInfo<>(list);
        long total = pageInfo.getTotal();
        return Page.of(total, ContractPoUtil.toEntityList(list));
    }

}
