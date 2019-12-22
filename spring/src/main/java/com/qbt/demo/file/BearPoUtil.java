package com.qbt.demo.file;

import com.qbt.demo.method.SimpleReflect;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BearPoUtil {
    /*autowired*/

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
            return bearPo;
        }
    }

    public Bear toEntity(BearPo bearPo) {
        if (bearPo == null) {
            return null;
        } else {
            Bear bear = new Bear();
            SimpleReflect.setter(bear, "id", bearPo.getId());
            return bear;
        }
    }

}
