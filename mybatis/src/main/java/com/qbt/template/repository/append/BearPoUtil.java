package com.qbt.template.repository.append;/*pack*/

import com.qbt.template.mock.SimpleReflect;
import com.yhhl.ebo.commom.persistence.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BearPoUtil {
    /*autowired*/
    @Autowired
    Repository<Candy> candyRepository;

    public Bear toEntity(BearPo bearPo) {
        if (bearPo == null) {
            return null;
        } else {
            Bear bear = new Bear();
            SimpleReflect.setter(bear, "id", bearPo.getId());
            /*setField*/
            SimpleReflect.setter(bear, "name", bearPo.getName());
            SimpleReflect.setter(bear, "code", bearPo.getCode());
            /*setMember*/
            {
                Long id = bearPo.getCandy();
                Candy entity = candyRepository.findById(id);
                SimpleReflect.setter(bear, "candy", entity);
            }
            {
                List<Candy> list = new ArrayList<>();
                String member = bearPo.getCandies();
                String[] split = member.split("/");
                for (String s : split) {
                    Long id = Long.valueOf(s);
                    Candy entity = candyRepository.findById(id);
                    list.add(entity);
                }
                SimpleReflect.setter(bear, "candies", list);
            }
            return bear;
        }
    }

    public List<Bear> toEntityList(List<BearPo> list) {
        if (list == null) {
            return null;
        } else {
            List<Bear> result = new ArrayList<>();
            for (BearPo bearPo : list) {
                Bear bear = toEntity(bearPo);
                result.add(bear);
            }
            return result;
        }
    }

    public BearPo toPo(Bear bear) {
        if (bear == null) {
            return null;
        } else {
            BearPo bearPo = new BearPo();
            bearPo.setId((Long) SimpleReflect.getter(bear, "id"));
            /*setPoField*/
            bearPo.setName((String) SimpleReflect.getter(bear, "name"));
            bearPo.setCode((String) SimpleReflect.getter(bear, "code"));
            /*setPoMember*/
            {
                Candy candy = (Candy) SimpleReflect.getter(bear, "candy");
                candyRepository.add(candy);
                bearPo.setCandy((Long) SimpleReflect.getter(candy, "id"));
            }
            {
                String s = "";
                List<Candy> list = (List<Candy>) SimpleReflect.getter(bear, "candies");
                if (list != null) {
                    for (Candy entity : list) {
                        candyRepository.add(entity);
                        s += SimpleReflect.getter(entity, "id") + "/";
                    }
                    bearPo.setCandies(s);
                }
            }
            return bearPo;
        }
    }

    public List<BearPo> toPoList(List<Bear> list) {
        if (list == null) {
            return null;
        } else {
            List<BearPo> result = new ArrayList<>();
            for (Bear bear : list) {
                BearPo bearPo = toPo(bear);
                result.add(bearPo);
            }
            return result;
        }
    }

}
