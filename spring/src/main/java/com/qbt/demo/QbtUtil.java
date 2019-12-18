package com.qbt.demo;

import java.io.*;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class QbtUtil {

    private static FileReader fileReader;


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
        } else {
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


    public static void myCodeGenerator(String from, String to, String pack, List<String> oldWord, List<String> newWord, List<String> position, List<String> content) throws Exception {
        FileReader fileReader = new FileReader(from);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        QbtUtil.createFile(to);
        FileWriter fileWriter = new FileWriter(to);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String s;
        s = bufferedReader.readLine();
        bufferedWriter.write("package " + pack + ";\n");
        if (position != null) {
            while ((s = bufferedReader.readLine()) != null) {
                for (int j = 0; j < oldWord.size(); j++) {
                    s = s.replaceAll(oldWord.get(j), newWord.get(j));
                }
                for (int j = 0; j < position.size(); j++) {
                    if (s.contains(position.get(j))) {
                        s += content.get(j);
                        break;
                    }
                }
                bufferedWriter.write(s + "\n");
            }
        } else {
            while ((s = bufferedReader.readLine()) != null) {
                for (int j = 0; j < oldWord.size(); j++) {
                    s = s.replaceAll(oldWord.get(j), newWord.get(j));
                }
                bufferedWriter.write(s + "\n");
            }
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    public static String toLower(String s) {
        char c = s.charAt(0);
        return Character.toLowerCase(c) + s.substring(1);
    }

    public static String toUpper(String s) {
        char c = s.charAt(0);
        return Character.toUpperCase(c) + s.substring(1);
    }

    public static String camelToUnderline(String str) {
        if (str == null || str.trim().isEmpty()) {
            return "";
        }
        int len = str.length();
        StringBuilder sb = new StringBuilder(len);
        sb.append(str.substring(0, 1).toLowerCase());
        for (int i = 1; i < len; i++) {
            char c = str.charAt(i);
            if (Character.isUpperCase(c)) {
                sb.append("_");
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}