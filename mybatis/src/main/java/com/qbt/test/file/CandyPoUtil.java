package com.qbt.test.file;

import com.qbt.test.mock.SimpleReflect;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CandyPoUtil {
    /*autowired*/

    public static Candy toEntity(CandyPo candyPo) {
        if (candyPo == null) {
            return null;
        } else {
            Candy candy = new Candy();
            SimpleReflect.setter(candy, "id", candyPo.getId());
            /*setField*/
            /*setMember*/
            return candy;
        }
    }

    public static List<Candy> toEntityList(List<CandyPo> list) {
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

    public static CandyPo toPo(Candy candy) {
        if (candy == null) {
            return null;
        } else {
            CandyPo candyPo = new CandyPo();
            candyPo.setId((Long) SimpleReflect.getter(candy, "id"));
            /*setPoField*/
            /*setPoMember*/
            return candyPo;
        }
    }

    public static List<CandyPo> toPoList(List<Candy> list) {
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
