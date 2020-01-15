package com.qbt.demo.method.file;

import com.qbt.demo.method.file.line.Term;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GG {

    private String oldWhere = "";
    private String oldPack = "";
    private String oldName = "";

    private String newWhere = "";
    private String newPack = "";
    private String newName = "";

    private String fields = "";

    private List<Term> terms = new ArrayList<>();

    public void afterSetter() {
        /*获取包名*/
        {
            int java = oldWhere.indexOf("java");
            String substring = oldWhere.substring(java + 5);
            oldPack = substring.replace("\\".charAt(0), ".".charAt(0));
        }
        {
            int java = newWhere.indexOf("java");
            String substring = newWhere.substring(java + 5);
            newPack = substring.replace("\\".charAt(0), ".".charAt(0));
        }
        /*对应类名修改*/
        {
            Term term = new Term();
            term.setOldWord(oldName);
            term.setNewWord(newName);
            terms.add(term);
        }
        {
            Term term = new Term();
            term.setOldWord(WordHandler.toLower(oldName));
            term.setNewWord(WordHandler.toLower(newName));
            terms.add(term);
        }
        {
            Term term = new Term();
            term.setWhere("/*package*/");
            term.setOldWord(oldPack);
            term.setNewWord(newPack);
            terms.add(term);
        }
    }

    public void append(String fileName, List<Term> terms) {
        FileG.append(
                newWhere + "\\" + newName + fileName + ".java",
                terms
        );
    }

    public void replace(String fileName) {
        FileG.replace(
                oldWhere + "\\" + oldName + fileName + ".java",
                newWhere + "\\" + newName + fileName + ".java",
                terms
        );
        {
            List<Term> terms = new ArrayList<>();
            Term term = new Term();
            term.setWhere("/*package*/");
            term.setContent("package "+newPack+";");
            terms.add(term);
            FileG.write(
                    newWhere + "\\" + newName + fileName + ".java",
                    terms
            );
        }
    }

}
