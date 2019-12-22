package com.qbt.demo.template;


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
public class ContractPoRepository implements Repository<Contract> {

    @Autowired
    private ContractPoDao contractPoDao;

    @Override
    public void add(Contract contract) {
        ContractPo contractPo = ContractPoUtil.toPo(contract);
        contractPoDao.add(contractPo);
        SimpleReflect.setter(contract, "id", contractPo.getId());
    }

    @Override
    public void update(Contract contract) {
        ContractPo contractPo = ContractPoUtil.toPo(contract);
        contractPoDao.update(contractPo);
    }

    @Override
    public void delete(Contract contract) {
        ContractPo contractPo = ContractPoUtil.toPo(contract);
        contractPoDao.delete(contractPo);
    }

    @Override
    public Contract findById(Long id) {
        ContractPo contractPo = contractPoDao.findById(id);
        Contract contract = ContractPoUtil.toEntity(contractPo);
        return contract;
    }

    @Override
    public List<Contract> findAll(Specification specification) {
        List<ContractPo> list = contractPoDao.findAll((ContractSpecification) specification);
        return ContractPoUtil.toEntityList(list);
    }

    @Override
    public Page<Contract> findAll(Specification specification, PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.pageNumber(), pageRequest.pageSize());
        List<ContractPo> list = contractPoDao.findAll((ContractSpecification) specification);
        PageInfo<ContractPo> pageInfo = new PageInfo<>(list);
        long total = pageInfo.getTotal();
        return Page.of(total, ContractPoUtil.toEntityList(list));
    }

}
