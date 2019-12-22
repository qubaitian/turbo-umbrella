package com.qbt.demo.util;

import com.qbt.demo.method.FileGenerator;
import com.qbt.demo.method.Term;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class NewGG {

    @Test
    public void name2() throws Exception {
        List<Term> terms = new ArrayList<>();
        List<String> toBeG = new ArrayList<>();
        toBeG.add("UpdateExp");
        toBeG.add("SelectFieldAndAlias");

        String toBeR = "InsertValue";
        String toBeAppend = "\n" +
                "        {\n" +
                "            String content = \"\";\n" +
                "            if (fieldList != null) {\n" +
                "                for (Field field : fieldList) {\n" +
                "                    content += \"\";\n" +
                "                }\n" +
                "            }\n" +
                "            if (memberList != null) {\n" +
                "                for (Member member : memberList) {\n" +
                "                    content += \"\";\n" +
                "                }\n" +
                "            }\n" +
                "            terms.add(new Term(\n" +
                "                    \"/*InsertValue*/\",\n" +
                "                    content\n" +
                "            ));\n" +
                "\n" +
                "        }";
        for (String s : toBeG) {
            String content = toBeAppend.replaceAll(toBeR, s);
            terms.add(
                    new Term(
                            "/*" + s + "*/",
                            content
                    )
            );
        }
        FileGenerator.append("C:\\work\\manual\\spring\\src\\test\\java\\com\\qbt\\demo\\util\\NewG.java", terms);
    }

    @Test
    public void name1() throws Exception {
        List<Term> terms = new ArrayList<>();
        List<String> toBeG = new ArrayList<>();
        toBeG.add("PoDao");
        toBeG.add("PoRepository");
        toBeG.add("PoUtil");
        toBeG.add("Specification");
        toBeG.add("Table");
        String toBeAppend = "    @Test\n" +
                "    public void createPo() throws Exception {\n" +
                "        FileGenerator.updateAndCreate(\n" +
                "                from + \"\\\\\" + old + \"Po.java\",\n" +
                "                there + \"\\\\\" + now + \"Po.java\",\n" +
                "                packAndUpAndLow\n" +
                "        );\n" +
                "    }";
        for (String s : toBeG) {
            String po = toBeAppend.replaceAll("Po", s);
            terms.add(
                    new Term(
                            "/*" + s + "*/",
                            po
                    )
            );
        }
        FileGenerator.append("C:\\work\\manual\\spring\\src\\test\\java\\com\\qbt\\demo\\util\\NewG.java", terms);
    }

}
