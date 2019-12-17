package com.qbt.demo;

import java.io.File;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;

public class Util {

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
            for (int i = 0; i < declaredFields.length; i++) {
                declaredFields[i].setAccessible(true);
                System.out.println(declaredFields[i].getName() + " " + declaredFields[i].get(o));
            }
        }
    }

    public static void createDir(String pack) {
        File myPath = new File(pack);
        if (!myPath.exists()) {
            myPath.mkdir();
            System.out.println("创建文件夹路径为：" + pack);
        }
    }

    public static void createFile(String fileName) throws Exception {
        File myPath = new File(fileName);
        if (!myPath.exists()) {
            boolean newFile = myPath.createNewFile();
            System.out.println("创建文件夹路径为：" + fileName);
        }
    }

    public static void insertContent(String filePath, String content, Long position) throws Exception {
        RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, "rw");
        randomAccessFile.seek(position);
        byte[] b = new byte[8];
        StringBuilder suffix = new StringBuilder();
        int len;
        while ((len = randomAccessFile.read(b)) != -1) {
            suffix.append(new String(b, 0, len));
        }
        randomAccessFile.seek(position);
        randomAccessFile.write(content.getBytes());
        randomAccessFile.write(suffix.toString().getBytes());
        randomAccessFile.close();
    }

}
