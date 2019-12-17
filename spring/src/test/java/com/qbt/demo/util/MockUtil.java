package com.qbt.demo.util;

import java.lang.reflect.Field;

public class MockUtil {

    public static Object getter(Object o, String fieldName) {
        try {
            Class c = o.getClass();
            Field field = c.getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void setter(Object o, String fieldName, Object content) {
        try {
            Class c = o.getClass();
            Field field = c.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(o, content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void toStr(Object o) throws IllegalAccessException {
        if (o == null) {
            System.out.println("已删除");
        }else{
            Class c = o.getClass();
            Field[] declaredFields = c.getDeclaredFields();
            System.out.println(o);
            for (int i = 0; i < declaredFields.length; i++) {
                declaredFields[i].setAccessible(true);
                System.out.println(declaredFields[i].getName() + " " + declaredFields[i].get(o));
            }
        }
    }

}
