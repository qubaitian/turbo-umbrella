package com.qbt.demo.template;

import com.qbt.demo.method.SimpleReflect;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContractPoUtil {
    /*autowired*/

    public static List<ContractPo> toPoList(List<Contract> list) {
        if (list == null) {
            return null;
        } else {
            List<ContractPo> result = new ArrayList<>();
            for (Contract contract : list) {
                ContractPo contractPo = toPo(contract);
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
                Contract contract = toEntity(contractPo);
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
            contractPo.setId((Long) SimpleReflect.getter(contract, "id"));
            /*setPoField*/
            /*setPoMember*/
            return contractPo;
        }
    }

    public static Contract toEntity(ContractPo contractPo) {
        if (contractPo == null) {
            return null;
        } else {
            Contract contract = new Contract();
            SimpleReflect.setter(contract, "id", contractPo.getId());
            /*setField*/
            /*setMember*/
            return contract;
        }
    }

}
