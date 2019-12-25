package com.qbt.demo.util;

import com.qbt.demo.method.FileG;
import com.qbt.demo.method.Term;
import com.qbt.demo.method.WordHandler;
import lombok.Data;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class NewG {

    private static List<Field> fieldList;
    private static List<Member> memberList;

    String from = "C:\\work\\manual\\spring\\src\\main\\java\\com\\qbt\\demo\\template";
    String there = "C:\\work\\manual\\spring\\src\\main\\java\\com\\qbt\\demo\\test";
    String old = "Contract";
    String now = "Bear";
    String fPack = "com.qbt.demo.template";
    String tPack = "com.qbt.demo.test";
    String fields = "\n" +
            "    private String name;\n" +
            "    private String code;";
    String members = "\n" +
            "    private Bear bear;\n" +
            "    private List<Bear> bears;";
    List<Term> packAndUpAndLow = new ArrayList<>();

    {
        solveField();
        solveMember();

        packAndUpAndLow.add(new Term(
                        null,
                        old,
                        now
                )
        );

        packAndUpAndLow.add(new Term(
                        null,
                        WordHandler.toLower(old),
                        WordHandler.toLower(now)
                )
        );

        packAndUpAndLow.add(new Term(
                "pack",
                fPack,
                tPack
        ));
    }

    /*entity*/
    @Test
    public void createEntity() throws Exception {
        FileG.replace(
                from + "\\" + old + ".java",
                there + "\\" + now + ".java",
                packAndUpAndLow
        );
        List<Term> terms = new ArrayList<>();
        terms.add(new Term(
                "/*fields*/",
                fields
        ));
        terms.add(new Term(
                "/*members*/",
                members
        ));
        FileG.append(
                there + "\\" + now + ".java",
                terms
        );
    }

    /*po*/
    @Test
    public void createPo() throws Exception {
        FileG.replace(
                from + "\\" + old + "Po.java",
                there + "\\" + now + "Po.java",
                packAndUpAndLow
        );

        List<Term> terms = new ArrayList<>();
        terms.add(new Term(
                "/*fields*/",
                fields
        ));

        String content = "";
        if (memberList != null) {
            for (Member member : memberList) {
                content += "\n    private " + member.getType() + " " + member.getName() + ";";
            }
        }
        terms.add(new Term(
                "/*members*/",
                content
        ));

    }

    /*PoDao*/
    @Test
    public void createPoDao() throws Exception {
        FileG.replace(
                from + "\\" + old + "PoDao.java",
                there + "\\" + now + "PoDao.java",
                packAndUpAndLow
        );

        List<Term> terms = new ArrayList<>();
        /*InsertField*/
        {
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
        }

        /*InsertValue*/
        {
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

        }
        /*UpdateExp*/
        {
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

        }
        /*SelectFieldAndAlias*/
        {
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
        }
    }

    /*PoRepository*/
    @Test
    public void createPoRepository() throws Exception {
        FileG.replace(
                from + "\\" + old + "PoRepository.java",
                there + "\\" + now + "PoRepository.java",
                packAndUpAndLow
        );
    }

    /*PoUtil*/
    @Test
    public void createPoUtil() throws Exception {
        FileG.replace(
                from + "\\" + old + "PoUtil.java",
                there + "\\" + now + "PoUtil.java",
                packAndUpAndLow
        );
    }

    /*Specification*/
    @Test
    public void createSpecification() throws Exception {
        FileG.replace(
                from + "\\" + old + "Specification.java",
                there + "\\" + now + "Specification.java",
                packAndUpAndLow
        );
    }

    /*Table*/
    @Test
    public void createTable() throws Exception {
        FileG.replace(
                from + "\\" + old + "Table.java",
                there + "\\" + now + "Table.java",
                packAndUpAndLow
        );
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

    @Data
    class Field {
        private String type;
        private String name;

        public Field() {
        }

        public Field(String type, String name) {
            this.type = type;
            this.name = name;
        }
    }

    @Data
    class Member {
        private String type;
        private String name;
        private String objType;

        public Member() {
        }

        public Member(String type, String name, String objType) {
            this.type = type;
            this.name = name;
            this.objType = objType;
        }
    }
}