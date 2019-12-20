package com.qbt.demo.test;

import com.qbt.demo.method.FileGenerator;
import com.qbt.demo.method.Term;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MethodTest {

    @Test
    public void name() throws Exception {
        String fileName="com.qbt.demo.template.repository.ContractPo";
        List<Term> list=new ArrayList<>();
        Term term = new Term();
        term.setWhere("pac");
        term.setOldWord("com");
        term.setNewWord("priv");
        list.add(term);
        FileGenerator.update(fileName,list);
    }
}
