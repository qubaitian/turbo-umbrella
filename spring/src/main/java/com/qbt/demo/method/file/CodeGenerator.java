package com.qbt.demo.method.file;

import com.qbt.demo.method.ReaderAndWriter;
import com.qbt.demo.method.file.line.LineGenerator;
import com.qbt.demo.method.file.line.Term;

import java.io.*;
import java.util.List;

public class CodeGenerator {

    private LineGenerator lineGenerator;

    public CodeGenerator(LineGenerator lineGenerator) {
        this.lineGenerator = lineGenerator;
    }

    private void createDir(String pack) {
        File myPath = new File(pack);
        if (!myPath.exists()) {
            myPath.mkdir();
            System.out.println("创建文件夹路径为：" + pack);
        }
    }

    private void createFile(String fileName) throws Exception {
        File myPath = new File(fileName);
        if (!myPath.exists()) {
            boolean newFile = myPath.createNewFile();
            System.out.println("创建文件夹路径为：" + fileName);
        }
    }

    private void destroy(ReaderAndWriter readerAndWriter) throws Exception {
        readerAndWriter.getWriter().flush();
        readerAndWriter.getWriter().close();
    }

    public void execute(String from, String to) throws Exception {
        ReaderAndWriter rw = stringToRW(from, to);
        String s;
        while ((s = rw.getReader().readLine()) != null) {
            rw.getWriter().write(s + "\n");
        }
        destroy(rw);
    }

    public void execute(String from, String to, List<Term> terms) throws Exception {
        ReaderAndWriter rw = stringToRW(from, to);
        String s;
        while ((s = rw.getReader().readLine()) != null) {
            s=lineGenerator.change(s, terms);
            rw.getWriter().write(s + "\n");
        }
        destroy(rw);
    }

    public void execute(String from, String to, String start, String end) throws Exception {
        ReaderAndWriter rw = stringToRW(from, to);
        String s;
        label:
        while ((s = rw.getReader().readLine()) != null) {
            if (s.contains(start)) {
                rw.getWriter().write(s + "\n");
                while ((s = rw.getReader().readLine()) != null) {
                    if (s.contains(end)) {
                        rw.getWriter().write(s + "\n");
                        break label;
                    }
                    rw.getWriter().write(s + "\n");
                }
            }
        }
        destroy(rw);
    }

    public void execute(String from, String to, String begin, String end, List<Term> terms) throws Exception {
        ReaderAndWriter rw = stringToRW(from, to);
        String s;
        label:
        while ((s = rw.getReader().readLine()) != null) {
            if (s.contains(begin)) {
                rw.getWriter().write(s + "\n");
                while ((s = rw.getReader().readLine()) != null) {
                    if (s.contains(end)) {
                        rw.getWriter().write(s + "\n");
                        break label;
                    }
                    s= lineGenerator.change(s, terms);
                    rw.getWriter().write(s + "\n");
                }
            }
        }
        destroy(rw);
    }

    private ReaderAndWriter stringToRW(String from, String to) throws Exception {
        FileReader fileReader = new FileReader(from);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        createFile(to);
        FileWriter fileWriter = new FileWriter(to);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        ReaderAndWriter readerAndWriter = new ReaderAndWriter();
        readerAndWriter.setReader(bufferedReader);
        readerAndWriter.setWriter(bufferedWriter);
        return readerAndWriter;
    }

}