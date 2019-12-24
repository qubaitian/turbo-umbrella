package com.qbt.demo.method;

import com.qbt.demo.method.file.AppendImpl;
import com.qbt.demo.method.file.CodeGenerator;
import com.qbt.demo.method.file.ReplaceImpl;

import java.util.List;

public class FileG {

    private static CodeGenerator copyImpl = new CodeGenerator(null);
    private static CodeGenerator appendImpl = new CodeGenerator(new AppendImpl());
    private static CodeGenerator replaceImpl = new CodeGenerator(new ReplaceImpl());

    public static void append(String from, String to, List<Term> terms) {
        try {
            appendImpl.execute(from, to, terms);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void append(String from, String to, String start, String end, List<Term> terms) {
        try {
            appendImpl.execute(from, to, start, end, terms);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void copy(String from, String to) {
        try {
            copyImpl.execute(from, to);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void copy(String from, String to, String start, String end) {
        try {
            copyImpl.execute(from, to, start, end);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void replace(String from, String to, List<Term> terms) {
        try {
            replaceImpl.execute(from, to, terms);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void replace(String from, String to, String start, String end, List<Term> terms) {
        try {
            replaceImpl.execute(from, to, start, end, terms);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
