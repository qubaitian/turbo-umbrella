package com.qbt.test.crud;

import com.qbt.test.mock.SimpleReflect;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TemplateEntityPoUtil {
    /*autowired*/

    public static TemplateEntity toEntity(TemplateEntityPo templateEntityPo) {
        if (templateEntityPo == null) {
            return null;
        } else {
            TemplateEntity templateEntity = new TemplateEntity();
            SimpleReflect.setter(templateEntity, "id", templateEntityPo.getId());
            /*setField*/
            /*setMember*/
            return templateEntity;
        }
    }

    public static List<TemplateEntity> toEntityList(List<TemplateEntityPo> list) {
        if (list == null) {
            return null;
        } else {
            List<TemplateEntity> result = new ArrayList<>();
            for (TemplateEntityPo templateEntityPo : list) {
                TemplateEntity templateEntity = toEntity(templateEntityPo);
                result.add(templateEntity);
            }
            return result;
        }
    }

    public static TemplateEntityPo toPo(TemplateEntity templateEntity) {
        if (templateEntity == null) {
            return null;
        } else {
            TemplateEntityPo templateEntityPo = new TemplateEntityPo();
            templateEntityPo.setId((Long) SimpleReflect.getter(templateEntity, "id"));
            /*setPoField*/
            /*setPoMember*/
            return templateEntityPo;
        }
    }

    public static List<TemplateEntityPo> toPoList(List<TemplateEntity> list) {
        if (list == null) {
            return null;
        } else {
            List<TemplateEntityPo> result = new ArrayList<>();
            for (TemplateEntity templateEntity : list) {
                TemplateEntityPo templateEntityPo = toPo(templateEntity);
                result.add(templateEntityPo);
            }
            return result;
        }
    }

}
