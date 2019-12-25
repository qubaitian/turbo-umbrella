package com.qbt.demo.method.file.repo;

import com.qbt.demo.method.file.FileG;
import com.qbt.demo.method.file.WordHandler;
import com.qbt.demo.method.file.line.Term;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;


public class RepoG {

    private List<Term> upAndLow = new ArrayList<>();
    private List<Term> upAndLowAndPack = new ArrayList<>();
    /*模板文件放在这*/
    private String template = "C:\\work\\manual\\mybatis\\src\\main\\java\\com\\qbt\\test\\crud";
    private String old = "TemplateEntity";
    private String templatePack = "com.qbt.test.crud";
    /*名 代码路径 包名*/
    private String now = "Bear";
    private String table = "bear";
    private String there = "C:\\work\\manual\\mybatis\\src\\main\\java\\com\\qbt\\test\\file";
    private String therePack = "com.qbt.test.file";
    /*mybatis能识别的类型*/
    private String fields = "\n" +
            "    private String name;\n" +
            "    private String code;";
    /*自定义的成员变量*/
    private String members = "\n" +
            "    private Bear bear;\n" +
            "    private List<Bear> bears;";
    private List<Field> fieldList = new ArrayList<>();
    private List<Member> memberList = new ArrayList<>();


    public RepoG(String template, String old, String templatePack, String now, String table, String there, String therePack, String fields, String members) {
        this.template = template;
        this.old = old;
        this.templatePack = templatePack;
        this.now = now;
        this.table = table;
        this.there = there;
        this.therePack = therePack;
        this.fields = fields;
        this.members = members;

        solveField();
        solveMember();
        solveUpAndLow();
        solveUpAndLowAndPack();

    }

    /*entity*/
    public void createEntity() throws Exception {
        String entity = template + "\\" + old + ".java";
        String entityTo = there + "\\" + now + ".java";
        FileG.replace(entity, entityTo, upAndLowAndPack);
        List<Term> terms = new ArrayList<>();
        terms.add(new Term("/*fields*/",
                fields));
        terms.add(new Term("/*members*/",
                members));
        FileG.append(entityTo, terms);
    }

    /*po*/
    public void createPo() throws Exception {
        String po = template + "\\" + old + "Po.java";
        String poTo = there + "\\" + now + "Po.java";
        FileG.replace(po, poTo, upAndLowAndPack);
        List<Term> terms = new ArrayList<>();
        terms.add(new Term("/*fields*/", fields));
        String content = "";
        if (memberList != null) {
            for (Member member : memberList) {
                content += "\n    private " + member.getType() + " " + member.getName() + ";";
            }
        }
        terms.add(new Term("/*members*/", content));
        FileG.append(poTo, terms);
    }

    /*PoDao*/
    public void createPoDao() throws Exception {
        String poDo = template + "\\" + old + "PoDao.java";
        String toPoDo = there + "\\" + now + "PoDao.java";

        FileG.replace(poDo, toPoDo, upAndLowAndPack);

        /*InsertField*/

        {
            List<Term> terms = new ArrayList<>();
            String content = "";
            if (fieldList != null) {
                for (Field field : fieldList) {
                    content += "\n            \" ," + WordHandler.camelToUnderline(field.getName()) + " \" +";
                }
            }
            if (memberList != null) {
                for (Member member : memberList) {
                    content += "\n            \" ," + WordHandler.camelToUnderline(member.getName()) + " \" +";
                }
            }
            terms.add(new Term(
                    "/*InsertField*/",
                    content
            ));
            FileG.append(toPoDo, terms);
        }

        /*InsertValue*/

        {
            List<Term> terms = new ArrayList<>();
            String content = "";
            if (fieldList != null) {
                for (Field field : fieldList) {
                    content += "\n            \" ,#{" + field.getName() + "} \" +";
                }
            }
            if (memberList != null) {
                for (Member member : memberList) {
                    content += "\n            \" ,#{" + member.getName() + "} \" +";
                }
            }
            terms.add(new Term(
                    "/*InsertValue*/",
                    content
            ));
            FileG.append(toPoDo, terms);
        }

        /*UpdateExp*/

        {
            List<Term> terms = new ArrayList<>();
            String content = "";
            if (fieldList != null) {
                for (Field field : fieldList) {
                    content += "\n            \"" + field.getName() + " = #{" + WordHandler.camelToUnderline(field.getName()) + "}, \" +";
                }
            }
            if (memberList != null) {
                for (Member member : memberList) {
                    content += "\n            \"" + member.getName() + " = #{" + WordHandler.camelToUnderline(member.getName()) + "}, \" +";
                }
            }
            terms.add(new Term(
                    "/*UpdateExp*/",
                    content
            ));
            FileG.append(toPoDo, terms);

        }

        /*SelectFieldAndAlias*/

        {
            List<Term> terms = new ArrayList<>();
            String content = "";
            if (fieldList != null) {
                for (Field field : fieldList) {
                    content += "\n            \" ," + WordHandler.camelToUnderline(field.getName()) + " " + field.getName() + " \" +";
                }
            }
            if (memberList != null) {
                for (Member member : memberList) {
                    content += "\n            \" ," + WordHandler.camelToUnderline(member.getName()) + " " + member.getName() + " \" +";
                }
            }
            terms.add(new Term(
                    "/*SelectFieldAndAlias*/",
                    content
            ));
            FileG.append(toPoDo, terms);
        }
    }

    /*PoRepository*/

    public void createPoRepository() throws Exception {
        String po = template + "\\" + old + "Po.java";
        String poTo = there + "\\" + now + "Po.java";
        FileG.replace(po, poTo, upAndLowAndPack);
    }

    /*PoUtil*/
    public void createPoUtil() throws Exception {
        String po = template + "\\" + old + "Po.java";
        String poTo = there + "\\" + now + "Po.java";
        FileG.replace(po, poTo, upAndLowAndPack);
    }

    /*Specification*/
    public void createSpecification() throws Exception {
        String po = template + "\\" + old + "Po.java";
        String poTo = there + "\\" + now + "Po.java";
        FileG.replace(po, poTo, upAndLowAndPack);
    }

    /*Table*/
    public void createTable() throws Exception {
        String table = "C:\\work\\table\\src\\main\\java\\com\\qbt\\table\\TemplateEntityTable.java";
        String tableTo = "C:\\work\\table\\src\\main\\java\\com\\qbt\\table";
        FileG.replace(table,
                tableTo + "\\" + now + "Table.java",
                upAndLow);
        List<Term> terms = new ArrayList<>();
        terms.add(new Term(
                "/*fields*/",
                fields));
        /*todo 还没写member*/
        FileG.append(
                tableTo + "\\" + now + "Table.java",
                terms);
    }

    private void solveField() {
        if (fields.contains(";")) {
            String[] split = fields.split(";");
            for (String s : split) {
                if (StringUtils.hasText(s)) {
                    String[] split1 = s.split("\\s+");
                    fieldList.add(new Field(split1[2], split1[3]));
                }
            }
        }
    }

    private void solveMember() {
        if (members.contains(";")) {
            memberList = new ArrayList<>();
            String[] split = members.split(";");
            for (String s : split) {
                if (StringUtils.hasText(s)) {
                    String[] split1 = s.split("\\s+");
                    if (split1[2].contains("List")) {
                        memberList.add(new Member("String", split1[3], split1[2]));
                    } else {
                        memberList.add(new Member("Long", split1[3], split1[2]));
                    }
                }
            }
        }
    }

    private void solveUpAndLow() {
        upAndLow.add(new Term(
                null,
                old,
                now));
        upAndLow.add(new Term(
                null,
                WordHandler.toLower(old),
                WordHandler.toLower(now)));
        upAndLow.add(new Term(
                "/*table*/",
                "template_entity",
                table));
    }

    private void solveUpAndLowAndPack() {
        upAndLowAndPack.addAll(upAndLow);
        upAndLowAndPack.add(new Term("pack", templatePack, therePack));
    }
}
