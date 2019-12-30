package com.qbt.template.repository.append;/*pack*/

import com.qbt.template.mock.SimpleReflect;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CandyPoUtil {
    /*autowired*/

    public Candy toEntity(CandyPo candyPo) {
        if (candyPo == null) {
            return null;
        } else {
            Candy candy = new Candy();
            SimpleReflect.setter(candy, "id", candyPo.getId());
            /*setField*/
            SimpleReflect.setter(candy, "name", candyPo.getName());
            SimpleReflect.setter(candy, "code", candyPo.getCode());
            /*setMember*/
            return candy;
        }
    }

    public List<Candy> toEntityList(List<CandyPo> list) {
        if (list == null) {
            return null;
        } else {
            List<Candy> result = new ArrayList<>();
            for (CandyPo candyPo : list) {
                Candy candy = toEntity(candyPo);
                result.add(candy);
            }
            return result;
        }
    }

    public CandyPo toPo(Candy candy) {
        if (candy == null) {
            return null;
        } else {
            CandyPo candyPo = new CandyPo();
            candyPo.setId((Long) SimpleReflect.getter(candy, "id"));
            /*setPoField*/
            candyPo.setName((String) SimpleReflect.getter(candy, "name"));
            candyPo.setCode((String) SimpleReflect.getter(candy, "code"));
            /*setPoMember*/
            return candyPo;
        }
    }

    public List<CandyPo> toPoList(List<Candy> list) {
        if (list == null) {
            return null;
        } else {
            List<CandyPo> result = new ArrayList<>();
            for (Candy candy : list) {
                CandyPo candyPo = toPo(candy);
                result.add(candyPo);
            }
            return result;
        }
    }

}
