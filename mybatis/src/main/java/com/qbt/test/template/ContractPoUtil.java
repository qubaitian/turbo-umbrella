package com.qbt.test.template;

import com.qbt.test.mock.SimpleReflect;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContractPoUtil {
    /*autowired*/

    public static List<ContractPo> toPoList(List<TemplateEntity> list) {
        if (list == null) {
            return null;
        } else {
            List<ContractPo> result = new ArrayList<>();
            for (TemplateEntity templateEntity : list) {
                ContractPo contractPo = toPo(templateEntity);
                result.add(contractPo);
            }
            return result;
        }
    }

    public static List<TemplateEntity> toEntityList(List<ContractPo> list) {
        if (list == null) {
            return null;
        } else {
            List<TemplateEntity> result = new ArrayList<>();
            for (ContractPo contractPo : list) {
                TemplateEntity templateEntity = toEntity(contractPo);
                result.add(templateEntity);
            }
            return result;
        }
    }

    public static ContractPo toPo(TemplateEntity templateEntity) {
        if (templateEntity == null) {
            return null;
        } else {
            ContractPo contractPo = new ContractPo();
            contractPo.setId((Long) SimpleReflect.getter(templateEntity, "id"));
            /*setPoField*/
            /*setPoMember*/
            return contractPo;
        }
    }

    public static TemplateEntity toEntity(ContractPo contractPo) {
        if (contractPo == null) {
            return null;
        } else {
            TemplateEntity templateEntity = new TemplateEntity();
            SimpleReflect.setter(templateEntity, "id", contractPo.getId());
            /*setField*/
            /*setMember*/
            return templateEntity;
        }
    }

}
