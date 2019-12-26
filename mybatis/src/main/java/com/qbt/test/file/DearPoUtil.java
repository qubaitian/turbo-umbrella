package com.qbt.test.file;/*pack*/

import com.qbt.test.mock.SimpleReflect;
import com.yhhl.ebo.commom.persistence.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DearPoUtil {
    /*autowired*/
    @Autowired
    Repository<Candy> candyRepository;

    public Dear toEntity(DearPo dearPo) {
        if (dearPo == null) {
            return null;
        } else {
            Dear dear = new Dear();
            SimpleReflect.setter(dear, "id", dearPo.getId());
            /*setField*/
            SimpleReflect.setter(dear, "name", dearPo.getName());
            SimpleReflect.setter(dear, "code", dearPo.getCode());
            /*setMember*/
            {
                Long id = dearPo.getCandy();
                Candy entity = candyRepository.findById(id);
                SimpleReflect.setter(dear, "candy", entity);
            }
            {
                List<Candy> list = new ArrayList<>();
                String member = dearPo.getCandies();
                String[] split = member.split("/");
                for (String s : split) {
                    Long id = Long.valueOf(s);
                    Candy entity = candyRepository.findById(id);
                    list.add(entity);
                }
                SimpleReflect.setter(dear, "candies", list);
            }
            return dear;
        }
    }

    public List<Dear> toEntityList(List<DearPo> list) {
        if (list == null) {
            return null;
        } else {
            List<Dear> result = new ArrayList<>();
            for (DearPo dearPo : list) {
                Dear dear = toEntity(dearPo);
                result.add(dear);
            }
            return result;
        }
    }

    public DearPo toPo(Dear dear) {
        if (dear == null) {
            return null;
        } else {
            DearPo dearPo = new DearPo();
            dearPo.setId((Long) SimpleReflect.getter(dear, "id"));
            /*setPoField*/
            dearPo.setName((String) SimpleReflect.getter(dear, "name"));
            dearPo.setCode((String) SimpleReflect.getter(dear, "code"));
            /*setPoMember*/
            {
                Candy candy = (Candy) SimpleReflect.getter(dear, "candy");
                candyRepository.add(candy);
                dearPo.setCandy((Long) SimpleReflect.getter(candy, "id"));
            }
            {
                String s = "";
                List<Candy> list = (List<Candy>) SimpleReflect.getter(dear, "candies");
                if (list != null) {
                    for (Candy entity : list) {
                        candyRepository.add(entity);
                        s += SimpleReflect.getter(entity, "id") + "/";
                    }
                    dearPo.setCandies(s);
                }
            }
            return dearPo;
        }
    }

    public List<DearPo> toPoList(List<Dear> list) {
        if (list == null) {
            return null;
        } else {
            List<DearPo> result = new ArrayList<>();
            for (Dear dear : list) {
                DearPo dearPo = toPo(dear);
                result.add(dearPo);
            }
            return result;
        }
    }

}
