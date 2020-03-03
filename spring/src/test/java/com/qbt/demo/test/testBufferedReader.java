package com.qbt.demo.test;

import org.junit.Test;

import java.io.*;

public class testBufferedReader {
    @Test
    public void test1() throws IOException {
        FileReader fileReader = new FileReader("C:\\work\\manual\\spring\\src\\test\\java\\com\\qbt\\demo\\test\\RepoGTest.java");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter("C:\\work\\manual\\spring\\src\\test\\java\\com\\qbt\\demo\\test\\a.java");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            System.out.println(s);
            bufferedWriter.write(s + "\n");
        }
        bufferedWriter.flush();
    }
}
