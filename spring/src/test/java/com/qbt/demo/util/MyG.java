package com.qbt.demo.util;

import com.qbt.demo.method.FileGenerator;
import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.qbt.demo.method.WordHandler.*;

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
        List<String> strings = Arrays.asList(old, toLower(old));
        List<String> strings1 = Arrays.asList(now, toLower(now));
        int i = from.lastIndexOf("\\");
        String fileName = from.substring(i + 1, from.length() - 5);
        fileName = fileName.replaceAll(strings.get(0), strings1.get(0));
        String s = to + "/" + fileName + ".java";
        FileGenerator.changeAndAppend(from, s, pack, strings, strings1, Arrays.asList("id"), Arrays.asList(fields));
    }

    @Test
    public void createTable() throws Exception {
        fileToPackageChangeOneWord(from + "\\" + old + "Table.java", to, pack, old, now, Arrays.asList("id"), Arrays.asList(fields));
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
        fileToPackageChangeOneWord(from + "\\" + old + "PoDao.java", to, pack, old, now, Arrays.asList("\" select id \"", "INSERT", "VALUES"), Arrays.asList(content, fields, values));
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

    @Test
    public void createPo() throws Exception {
        fileToPackageChangeOneWord(from + "\\" + old + "Po.java", to, pack, old, now, Arrays.asList("id"), Arrays.asList(fields));
    }

    @Test
    public void createSpecification() throws Exception {
        simpleChange(from + "\\" + old + "Specification.java", to, pack, old, now);
    }

    @Test
    public void createPoRepository() throws Exception {
        simpleChange(from + "\\" + old + "PoRepository.java", to, pack, old, now);
    }

    public static void simpleChange(String from, String to, String pack, String old, String now) throws Exception {
        fileToPackageChangeOneWord(from, to, pack, old, now, null, null);
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

    public static void fileToPackageChangeOneWord(String from, String to, String pack, String old, String now, List<String> position, List<String> content) throws Exception {
        List<String> strings = Arrays.asList(old, toLower(old));
        List<String> strings1 = Arrays.asList(now, toLower(now));
        int i = from.lastIndexOf("\\");
        String fileName = from.substring(i + 1, from.length() - 5);
        fileName = fileName.replaceAll(strings.get(0), strings1.get(0));
        String s = to + "/" + fileName + ".java";
        FileGenerator.changeAndAppend(from, s, pack, strings, strings1, position, content);
    }

    @Data
    static
    class TypeListAndNameList {
        List<String> typeList = new ArrayList<>();
        List<String> nameList = new ArrayList<>();
    }

}
