package com.qbt.demo.util;

import com.qbt.demo.method.Term;
import com.qbt.demo.method.WordHandler;
import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.qbt.demo.method.WordHandler.*;

public class MyG {

    String from = "C:\\work\\manual\\spring\\src\\main\\java\\com\\qbt\\demo\\template";
    String fPack = "com.qbt.demo.template";

    String there = "C:\\work\\manual\\spring\\src\\test\\java\\com\\qbt\\demo\\test";
    String tPack = "com.qbt.demo.test";

    String old = "Contract";
    String now = "Apple";

    String fields = "\n" +
            "";

    String to = "";
    String pack = "";
    TypeListAndNameList typeListAndNameList = getTypeListAndNameList(fields);
    String obj = "C:\\work\\manual\\spring\\src\\main\\java\\com\\qbt\\demo\\template\\Contract.java";

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
        fileToPackageChangeOneWord(from + "\\" + old + "PoDao.java", to, pack, old, now, Arrays.asList("\" select id \"", "INSERT", "VALUES"), Arrays.asList(content, fields, values));
    }

    @Test
    public void createObj() throws Exception {

        List<Term> terms = new ArrayList<>();
        terms.add(new Term(
                        null,
                        old,
                        now
                )
        );
        terms.add(new Term(
                        null,
                        WordHandler.toLower(old),
                        WordHandler.toLower(now)
                )
        );

        terms.add(new Term(
                "pack",
                fPack,
                tPack
        ));

        int lastIndexOf = obj.lastIndexOf("\\");
        String fileName = obj.substring(lastIndexOf + 1, obj.length() - 5);
        fileName = fileName.replaceAll(old, now);
//        FileGenerator.updateAndCreate(
//                obj,
//                there + "\\" + fileName + ".java",
//                terms
//        );

    }

    @Test
    public void createPo() throws Exception {
        fileToPackageChangeOneWord(from + "\\" + old + "Po.java", to, pack, old, now, Arrays.asList("id"), Arrays.asList(fields));
    }

    @Test
    public void createPoRepository() throws Exception {
        simpleChange(from + "\\" + old + "PoRepository.java", to, pack, old, now);
    }

    @Test
    public void createSpecification() throws Exception {
        simpleChange(from + "\\" + old + "Specification.java", to, pack, old, now);
    }

    @Test
    public void createTable() throws Exception {
        fileToPackageChangeOneWord(from + "\\" + old + "Table.java", to, pack, old, now, Arrays.asList("id"), Arrays.asList(fields));
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
    public void createUtil() throws Exception {
        String getStr = "";
        for (int i = 0; i < typeListAndNameList.getTypeList().size(); i++) {
            getStr += "\n" + toLower(now) + "Po.set" + toUpper(typeListAndNameList.getNameList().get(i)) + "((" + typeListAndNameList.getTypeList().get(i) + ") getter(" + toLower(now) + ", \"" + typeListAndNameList.getNameList().get(i) + "\"));";
        }
        String setStr = "";
        for (int i = 0; i < typeListAndNameList.getTypeList().size(); i++) {
            setStr += "\nsetter(" + toLower(now) + ", \"" + typeListAndNameList.getNameList().get(i) + "\", " + toLower(now) + "Po.get" + toUpper(typeListAndNameList.getNameList().get(i)) + "());";
        }
        fileToPackageChangeOneWord(from + "\\" + old + "PoUtil.java", to, pack, old, now, Arrays.asList("setId", "getId"), Arrays.asList(getStr, setStr));
    }

    public static void fileToPackageChangeOneWord(String from, String to, String pack, String old, String now, List<String> position, List<String> content) throws Exception {
        List<String> strings = Arrays.asList(old, toLower(old));
        List<String> strings1 = Arrays.asList(now, toLower(now));
        int i = from.lastIndexOf("\\");
        String fileName = from.substring(i + 1, from.length() - 5);
        fileName = fileName.replaceAll(strings.get(0), strings1.get(0));
        String s = to + "/" + fileName + ".java";
//        FileGenerator.changeAndAppend(from, s, pack, strings, strings1, position, content);
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

    public static void simpleChange(String from, String to, String pack, String old, String now) throws Exception {
        fileToPackageChangeOneWord(from, to, pack, old, now, null, null);
    }

    @Data
    private class TypeListAndNameList {
        List<String> typeList = new ArrayList<>();
        List<String> nameList = new ArrayList<>();
    }

}
