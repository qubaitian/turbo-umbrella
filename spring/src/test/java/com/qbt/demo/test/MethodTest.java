package com.qbt.demo.test;

import com.qbt.demo.method.FileG;
import com.qbt.demo.method.Term;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MethodTest {

    String from = "C:\\work\\manual\\spring\\src\\main\\java\\com\\qbt\\demo\\template\\Contract.java";
    String to = "C:\\work\\manual\\spring\\src\\main\\java\\com\\qbt\\demo\\test\\Test";

    @Test
    void test1() {
        FileG.copy(from, to);
    }

    @Test
    void test2() {
        FileG.copy(from, to, "/*fields*/", "/*members*/");
    }

    @Test
    void test3() {
        List<Term> terms = new ArrayList<>();
        terms.add(new Term(
                "/*",
                "111")
        );
        FileG.append(from, to, terms);
    }

    @Test
    void test4() {
        List<Term> terms = new ArrayList<>();
        terms.add(new Term(
                "/*",
                "111")
        );
        FileG.append(from, to, "fields", "members", terms);
    }

    @Test
    void test5() {
        List<Term> terms = new ArrayList<>();
        terms.add(new Term(
                "/*",
                "111",
                "7777")
        );
        FileG.replace(from, to, "fields", "members", terms);
    }

    @Test
    void test6() {
        List<Term> terms = new ArrayList<>();
        terms.add(new Term(
                "/*",
                "111",
                "7777")
        );
        FileG.replace(from, to, terms);

    }
}
