package com.qbt.demo.util;

import com.qbt.demo.Util;
import lombok.Data;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyG {

    String here = "C:\\repo\\work\\spring_test\\src\\main\\java\\com\\qbt\\test\\testTemplate";
    String hPack = "com.qbt.test.testTemplate";

    String from = "C:\\repo\\work\\spring_test\\src\\main\\java\\com\\qbt\\test\\repotemplate";

    String there = "C:\\repo\\work\\spring_test\\src\\main\\java\\com\\qbt\\test\\testTemplate";
    String tPack = "com.qbt.test.testTemplate";

    String old = "Contract";
    String now = "Apple";

    String fields = "\n" +
            "    private String code;\n" +
            "    private String label;\n" +
            "    private Integer def;\n" +
            "    private String extData;";

    TypeListAndNameList typeListAndNameList = getTypeListAndNameList(fields);
    String to = "";
    String pack = "";

    @Test
    public void createHere() throws Exception {
        to = here;
        pack = hPack;
        createObj();
        createPo();
        createDao();
        createTable();
        createPoRepository();
        createUtil();
        createSpecification();
    }

    @Test
    public void createThere() throws Exception {
        to = there;
        pack = tPack;
        createPo();
        createDao();
        createPoRepository();
        createUtil();
    }

    @Test
    public void createObj() throws Exception {
        modify(from + "\\" + old + ".java", to, pack, old, now, Arrays.asList("id"), Arrays.asList(fields));
    }

    @Test
    public void createTable() throws Exception {
        modify(from + "\\" + old + "Table.java", to, pack, old, now, Arrays.asList("id"), Arrays.asList(fields));
    }


    @Test
    public void createDao() throws Exception {

        List<String> nameList = typeListAndNameList.getNameList();
        String content = "";
        String fields = "";
        String values = "";
        for (String s : nameList) {
            content += "\n\" ," + camelToUnderline(s) + " " + s + " \"+";
            fields += "\n\" ," + camelToUnderline(s) + " \"+";
            values += "\n\" ,#{" + s + "} \"+";
        }
        modify(from + "\\" + old + "PoDao.java", to, pack, old, now, Arrays.asList("\" select id \"", "INSERT", "VALUES"), Arrays.asList(content, fields, values));
    }

    @Test
    public void createUtil() throws Exception {
        String getStr = "";
        for (int i = 0; i < typeListAndNameList.getTypeList().size(); i++) {
            getStr += "\n" + toLower(now) + "Po.set" + toUpper(typeListAndNameList.getNameList().get(i)) + "((" + typeListAndNameList.getTypeList().get(i) + ") getter(" + toLower(now) + ", \"" + typeListAndNameList.getNameList().get(i) + "\"));";
        }
        String setStr = "";
        for (int i = 0; i < typeListAndNameList.getTypeList().size(); i++) {
            setStr += "\nsetter(" + toLower(now) + ", \"" + typeListAndNameList.getNameList().get(i) + "\", " + toLower(now) + "Po.get" + toUpper(typeListAndNameList.getNameList().get(i)) + "());";
        }
        modify(from + "\\" + old + "PoUtil.java", to, pack, old, now, Arrays.asList("setId", "getId"), Arrays.asList(getStr, setStr));
    }

    @Test
    public void createPo() throws Exception {
        modify(from + "\\" + old + "Po.java", to, pack, old, now, Arrays.asList("id"), Arrays.asList(fields));
    }

    @Test
    public void createSpecification() throws Exception {
        copy(from + "\\" + old + "Specification.java", to, pack, old, now);
    }

    @Test
    public void createPoRepository() throws Exception {
        copy(from + "\\" + old + "PoRepository.java", to, pack, old, now);
    }

    void copy(String from, String to, String pack, String old, String now) throws Exception {
        FileReader fileReader = new FileReader(from);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int i = from.lastIndexOf("\\");
        String fileName = from.substring(i + 1, from.length() - 5);
        fileName = fileName.replaceAll(old, now);
        Util.createFile(to + "/" + fileName + ".java");
        FileWriter fileWriter = new FileWriter(to + "/" + fileName + ".java");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String s;
        s = bufferedReader.readLine();
        bufferedWriter.write("package " + pack + ";\n");
        while ((s = bufferedReader.readLine()) != null) {
            s = s.replaceAll(old, now);
            s = s.replaceAll(toLower(old), toLower(now));
            bufferedWriter.write(s + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    void modify(String from, String to, String pack, String old, String now, List<String> position, List<String> content) throws Exception {
        FileReader fileReader = new FileReader(from);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int i = from.lastIndexOf("\\");
        String fileName = from.substring(i + 1, from.length() - 5);
        fileName = fileName.replaceAll(old, now);
        Util.createFile(to + "/" + fileName + ".java");
        FileWriter fileWriter = new FileWriter(to + "/" + fileName + ".java");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String s;
        s = bufferedReader.readLine();
        bufferedWriter.write("package " + pack + ";\n");
        while ((s = bufferedReader.readLine()) != null) {
            s = s.replaceAll(old, now);
            s = s.replaceAll(toLower(old), toLower(now));

            for (int j = 0; j < position.size(); j++) {
                if (s.contains(position.get(j))) {
                    s += content.get(j);
                    break;
                }
            }
            bufferedWriter.write(s + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }


    String toLower(String s) {
        char c = s.charAt(0);
        return Character.toLowerCase(c) + s.substring(1);
    }

    String toUpper(String s) {
        char c = s.charAt(0);
        return Character.toUpperCase(c) + s.substring(1);
    }

    TypeListAndNameList getTypeListAndNameList(String fields) {
        String[] split = fields.split("[^A-z]");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            if (!split[i].isEmpty()) {
                list.add(split[i]);
            }
        }
        List<String> type = new ArrayList<>();
        List<String> name = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (i % 3 == 1) {
                type.add(list.get(i));
            }
            if (i % 3 == 2) {
                name.add(list.get(i));
            }
        }
        TypeListAndNameList typeListAndNameList = new TypeListAndNameList();
        typeListAndNameList.setTypeList(type);
        typeListAndNameList.setNameList(name);
        return typeListAndNameList;
    }


    String camelToUnderline(String str) {
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

    @Data
    static
    class TypeListAndNameList {
        List<String> typeList = new ArrayList<>();
        List<String> nameList = new ArrayList<>();
    }
}
