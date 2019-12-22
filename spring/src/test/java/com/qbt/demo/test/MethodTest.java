package com.qbt.demo.test;

import com.qbt.demo.method.FileGenerator;
import com.qbt.demo.method.Term;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class MethodTest {

    @Test
    public void updateTest() throws Exception {
        String fileName="C:\\work\\manual\\spring\\src\\main\\java\\com\\qbt\\demo\\test\\Apple.java";
        List<Term> terms=new ArrayList<>();
        terms.add(new Term(
                "if",
                null,
                " /*adsf*/ "
        ));
        FileGenerator.append(fileName,terms);
    }

    @Test
    public void name() throws Exception {
        String fileName = "C:\\work\\manual\\spring\\src\\main\\java\\com\\qbt\\demo\\template\\repository\\ContractPo.java";
        List<Term> list = new ArrayList<>();
        Term term = new Term();
        term.setWhere("pac");
        term.setOldWord("com");
        term.setNewWord("priv");
        list.add(term);
        FileGenerator.update(fileName, list);
    }

    @Test
    public void name1() {
        System.out.println(StringUtils.hasText(null));
        System.out.println(StringUtils.hasText("  "));
    }
}
