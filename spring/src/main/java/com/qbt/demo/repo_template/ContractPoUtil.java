package com.qbt.demo.repo_template;

import java.util.ArrayList;
import java.util.List;

import static com.qbt.demo.Util.getter;
import static com.qbt.demo.Util.setter;


public class ContractPoUtil {

    public static List<ContractPo> toPoList(List<Contract> list) {
        if (list == null) {
            return null;
        } else {
            List<ContractPo> result = new ArrayList<>();
            for (Contract contract : list) {
                ContractPo contractPo = ContractPoUtil.toPo(contract);
                result.add(contractPo);
            }
            return result;
        }
    }


    public static List<Contract> toEntityList(List<ContractPo> list) {
        if (list == null) {
            return null;
        } else {
            List<Contract> result = new ArrayList<>();
            for (ContractPo contractPo : list) {
                Contract contract = ContractPoUtil.toEntity(contractPo);
                result.add(contract);
            }
            return result;
        }
    }

    public static ContractPo toPo(Contract contract) {
        if (contract == null) {
            return null;
        } else {
            ContractPo contractPo = new ContractPo();
            contractPo.setId((Long) getter(contract, "id"));
            return contractPo;
        }
    }

    public static Contract toEntity(ContractPo contractPo) {
        if (contractPo == null) {
            return null;
        } else {
            Contract contract = new Contract();
            setter(contract, "id", contractPo.getId());
            return contract;
        }
    }

}
