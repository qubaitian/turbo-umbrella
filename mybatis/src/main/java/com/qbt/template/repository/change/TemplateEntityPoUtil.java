package com.qbt.template.repository.change;/*pack*/

import com.qbt.template.mock.SimpleReflect;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TemplateEntityPoUtil {
    /*autowired*/

    public TemplateEntity toEntity(TemplateEntityPo templateEntityPo) {
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

    public List<TemplateEntity> toEntityList(List<TemplateEntityPo> list) {
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

    public TemplateEntityPo toPo(TemplateEntity templateEntity) {
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

    public List<TemplateEntityPo> toPoList(List<TemplateEntity> list) {
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
