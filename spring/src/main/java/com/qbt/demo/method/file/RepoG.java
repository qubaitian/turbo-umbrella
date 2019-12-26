package com.qbt.demo.method.file;

import com.qbt.demo.method.file.line.Term;
import com.qbt.demo.method.file.repo.Field;
import com.qbt.demo.method.file.repo.Member;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;


public class RepoG {

    private List<Term> upAndLow = new ArrayList<>();
    private List<Term> upAndLowAndPack = new ArrayList<>();
    /*模板文件放在这*/
    private String template;
    private String old;
    private String templatePack;
    /*名 代码路径 包名*/
    private String now;
    private String table;
    private String there;
    private String therePack;


    /*mybatis能识别的类型*/
    private String fields;
    /*自定义的成员变量*/
    private String members;
    private List<Field> fieldList;
    private List<Member> memberList;


    public RepoG(String now, String table, String there, String therePack, String fields, String members) {
        this.template = "C:\\work\\manual\\mybatis\\src\\main\\java\\com\\qbt\\test\\crud";
        this.old = "TemplateEntity";
        this.templatePack = "com.qbt.test.crud";

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
    public void createEntity() {

        String entity = template + "\\" + old + ".java";
        String toEntity = there + "\\" + now + ".java";
        FileG.replace(entity, toEntity, upAndLowAndPack);

        List<Term> terms = new ArrayList<>();
        terms.add(new Term("/*fields*/", fields));
        terms.add(new Term("/*members*/", members));
        FileG.append(toEntity, terms);

    }

    /*po*/
    public void createPo() {

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
        String poRepository = template + "\\" + old + "PoRepository.java";
        String toPoRepository = there + "\\" + now + "PoRepository.java";
        FileG.replace(poRepository, toPoRepository, upAndLowAndPack);
    }

    /*PoUtil*/
    public void createPoUtil() throws Exception {
        String poUtil = template + "\\" + old + "PoUtil.java";
        String toPoUtil = there + "\\" + now + "PoUtil.java";
        FileG.replace(poUtil, toPoUtil, upAndLowAndPack);
    }

    /*Specification*/
    public void createSpecification() throws Exception {
        String specification = template + "\\" + old + "Specification.java";
        String toSpecification = there + "\\" + now + "Specification.java";
        FileG.replace(specification, toSpecification, upAndLowAndPack);
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
            fieldList = new ArrayList<>();
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
