package com.qbt.demo.test;/*pack*/

import com.qbt.demo.method.file.FileG;
import com.qbt.demo.method.file.WordHandler;
import com.qbt.demo.method.file.line.Term;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ExportFile {
    @Test
    void export() {
        String from="C:\\work\\manual\\mybatis\\src\\main\\java\\com\\qbt\\test\\file\\CandyPoUtil.java";
        String to="C:\\work\\manual\\mybatis\\src\\main\\java\\com\\qbt\\test\\crud\\TemplateEntityPoUtil.java";

        String old="Candy";
        String now="TemplateEntity";

        List<Term> terms=new ArrayList<>();
        terms.add(new Term(
                "/*pack*/",
                "com.qbt.test.file",
                "com.qbt.test.crud"
        ));
        terms.add(new Term(
                null,
                old,
                now));
        terms.add(new Term(
                null,
                WordHandler.toLower(old),
                WordHandler.toLower(now)));

        FileG.replace(from,to,terms);
    }
}
