package com.qbt.demo.util;

import com.qbt.demo.method.FileGenerator;
import com.qbt.demo.method.PrivateUtil;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class AhkGenerator {

    @Test
    public void addSsh() throws Exception {
//        addSsh("45", "45.32.89.238", "root", "F1.dDX%62DFN7{AU");
    }

    private void addSsh(String nick, String url, String name, String pw) throws Exception {
        String[] split = url.split(".");
        PrivateUtil.insertContent("C:\\work\\spring_proj\\src\\test\\java\\com\\qbt\\test\\ahk\\working.ahk", "\n", 0L);
        AhkString("ssh" + nick, "ssh " + name + "@" + url);
        AhkString("a" + nick, url);
        AhkString("p" + nick, pw);
        AhkString("n" + nick, name);
    }


    @Test
    void addCode8() throws Exception {
        AhkString("pss", pGenerate(8));
    }

    @Test
    void addCode10() throws Exception {
        AhkString("pau", pGenerate(10));
    }

    @Test
    void addString() throws Exception {
        String s = "xinqing/hao";
        String[] split = s.split("/", 2);
        AhkString(split[0], split[1]);
    }

    private static void AhkString(String name, String content) throws Exception {
        PrivateUtil.insertContent("C:\\work\\spring_proj\\src\\test\\java\\com\\qbt\\test\\ahk\\working.ahk", "::" + name + "::" + content + "\n", 0L);
    }


    private void addLine(String fileName,String where,String content) throws Exception {
        FileGenerator.changeAndAppend(fileName,fileName,"", new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
    }

    private static String pGenerate(int digit) {
        String p = "Aa1.";
        Random random = new Random();
        for (int i = 0; i < digit - 4; i++) {
            int i1 = random.nextInt(83);
            char c = (char) (i1 + 33);
            p += c;
        }
        return p;
    }

}


