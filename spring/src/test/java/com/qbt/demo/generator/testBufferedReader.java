package com.qbt.demo.generator;

import org.junit.Test;

import java.io.*;

public class testBufferedReader {
  @Test
  public void test1() throws IOException {
    FileReader fileReader = new FileReader("C:\\work\\manual\\spring\\src\\test\\java\\com\\qbt\\demo\\generator\\b.md");
    BufferedReader bufferedReader = new BufferedReader(fileReader);
    FileWriter fileWriter = new FileWriter("C:\\work\\manual\\spring\\src\\test\\java\\com\\qbt\\demo\\generator\\a.md");
    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
    while (true) {
      String s = bufferedReader.readLine();
      if (s == null) {
        break;
      } else {
        bufferedWriter.write(s + "\n");
      }
    }
    bufferedWriter.flush();
  }
}
