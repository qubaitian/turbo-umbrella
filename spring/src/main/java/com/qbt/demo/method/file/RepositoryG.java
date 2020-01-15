package com.qbt.demo.method.file;

import com.qbt.demo.method.file.line.Term;
import com.qbt.demo.method.file.repo.Field;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Data
public class RepositoryG extends GG {
    private String tableName = "";
    private String entity = "";
    private String fields = "";
    private List<Field> fieldList;

    @Override
    public void afterSetter() {
        super.afterSetter();
        {
            Term term = new Term();
            term.setWhere("/*table*/");
            term.setOldWord("tableName");
            term.setNewWord(tableName);
            getTerms().add(term);
        }
        {
            if (StringUtils.hasText(entity)) {
                fields = FileG.read(
                        entity,
                        "/*fields*/",
                        "/*fields*/"
                );
            }
        }
        {
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
    }

    public void createAnEntity() {
        replace("");
        {
            List<Term> terms = new ArrayList<>();
            Term term = new Term();
            term.setWhere("/*fields*/");
            term.setContent(fields);
            terms.add(term);
            append("", terms);
        }
    }

    public void createDao() {
        replace("Dao");
        /*InsertField*/
        {
            List<Term> terms = new ArrayList<>();
            String content = "";
            if (fieldList != null) {
                for (Field field : fieldList) {
                    content += "\n            \" ," + WordHandler.camelToUnderline(field.getName()) + " \" +";
                }
            }
            terms.add(new Term(
                    "/*InsertField*/",
                    content
            ));
            append("Dao", terms);
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
            terms.add(new Term(
                    "/*InsertValue*/",
                    content
            ));
            append("Dao", terms);
        }
        /*UpdateExp*/
        {
            List<Term> terms = new ArrayList<>();
            String content = "";
            if (fieldList != null) {
                for (Field field : fieldList) {
                    content += "\n            \"" + WordHandler.camelToUnderline(field.getName()) + " = #{" + field.getName() + "}, \" +";
                }
            }
            terms.add(new Term(
                    "/*UpdateExp*/",
                    content
            ));
            append("Dao", terms);
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
            terms.add(new Term(
                    "/*SelectFieldAndAlias*/",
                    content
            ));
            append("Dao", terms);
        }
    }

    public void createRepository() {
        replace("Repository");
    }

    public void createSpecification() {
        replace("Specification");
    }


    public void createTable() {
        FileG.replace(
                "C:\\work\\manual\\table\\src\\main\\java\\com\\qbt\\table\\TemplateTable.java",
                "C:\\work\\manual\\table\\src\\main\\java\\com\\qbt\\table\\" + getNewName() + "Table.java",
                getTerms()
        );
        {
            List<Term> terms = new ArrayList<>();
            Term term = new Term();
            term.setWhere("/*fields*/");
            term.setContent(fields);
            terms.add(term);
            FileG.append(
                    "C:\\work\\manual\\table\\src\\main\\java\\com\\qbt\\table\\" + getNewName() + "Table.java",
                    terms
            );
        }
    }
}
