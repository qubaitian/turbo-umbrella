package com.qbt.template.test;/*pack*/

import com.qbt.template.mock.SimpleReflect;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FootballPoUtil {
    /*autowired*/

    public Football toEntity(FootballPo footballPo) {
        if (footballPo == null) {
            return null;
        } else {
            Football football = new Football();
            SimpleReflect.setter(football, "id", footballPo.getId());
            /*setField*/
            SimpleReflect.setter(football, "name", footballPo.getName());
            SimpleReflect.setter(football, "code", footballPo.getCode());
            /*setMember*/
            return football;
        }
    }

    public List<Football> toEntityList(List<FootballPo> list) {
        if (list == null) {
            return null;
        } else {
            List<Football> result = new ArrayList<>();
            for (FootballPo footballPo : list) {
                Football football = toEntity(footballPo);
                result.add(football);
            }
            return result;
        }
    }

    public FootballPo toPo(Football football) {
        if (football == null) {
            return null;
        } else {
            FootballPo footballPo = new FootballPo();
            footballPo.setId((Long) SimpleReflect.getter(football, "id"));
            /*setPoField*/
            footballPo.setName((String) SimpleReflect.getter(football, "name"));
            footballPo.setCode((String) SimpleReflect.getter(football, "code"));
            /*setPoMember*/
            return footballPo;
        }
    }

    public List<FootballPo> toPoList(List<Football> list) {
        if (list == null) {
            return null;
        } else {
            List<FootballPo> result = new ArrayList<>();
            for (Football football : list) {
                FootballPo footballPo = toPo(football);
                result.add(footballPo);
            }
            return result;
        }
    }

}
