package com.qbt.demo.file;

import com.qbt.demo.method.SimpleReflect;

import java.util.ArrayList;
import java.util.List;

public class ApplePoUtil {

    public static List<ApplePo> toPoList(List<Apple> list) {
        if (list == null) {
            return null;
        } else {
            List<ApplePo> result = new ArrayList<>();
            for (Apple apple : list) {
                ApplePo applePo = ApplePoUtil.toPo(apple);
                result.add(applePo);
            }
            return result;
        }
    }

    public static List<Apple> toEntityList(List<ApplePo> list) {
        if (list == null) {
            return null;
        } else {
            List<Apple> result = new ArrayList<>();
            for (ApplePo applePo : list) {
                Apple apple = ApplePoUtil.toEntity(applePo);
                result.add(apple);
            }
            return result;
        }
    }

    public static ApplePo toPo(Apple apple) {
        if (apple == null) {
            return null;
        } else {
            ApplePo applePo = new ApplePo();
            applePo.setId((Long) SimpleReflect.getter(apple, "id"));
            return applePo;
        }
    }

    public static Apple toEntity(ApplePo applePo) {
        if (applePo == null) {
            return null;
        } else {
            Apple apple = new Apple();
            SimpleReflect.setter(apple, "id", applePo.getId());
            return apple;
        }
    }

}
