package com.qbt.demo.method;

import java.io.*;
import java.util.List;

public class FileGenerator {

    public static void createDir(String pack) {
        File myPath = new File(pack);
        if (!myPath.exists()) {
            myPath.mkdir();
            System.out.println("创建文件夹路径为：" + pack);
        }
    }

    public static void createFile(String fileName) throws Exception {
        File myPath = new File(fileName);
        if (!myPath.exists()) {
            boolean newFile = myPath.createNewFile();
            System.out.println("创建文件夹路径为：" + fileName);
        }
    }

    public static void append(String fileName, String where, String contend) throws Exception {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int i = fileName.lastIndexOf("\\");
        String temp = fileName.substring(0, i) + "\\temp";
        FileGenerator.createFile(temp);
        FileWriter fileWriter = new FileWriter(temp);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            if (s.contains(where)) {
                s += contend;
            }
            bufferedWriter.write(s + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    public static void change(String from, String to, List<String> oldWords, List<String> newWords) throws Exception {
        FileReader fileReader = new FileReader(from);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        createFile(to);
        FileWriter fileWriter = new FileWriter(to);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String s;
        if (oldWords != null) {
            while ((s = bufferedReader.readLine()) != null) {
                for (int j = 0; j < oldWords.size(); j++) {
                    s = s.replaceAll(oldWords.get(j), newWords.get(j));
                    bufferedWriter.write(s + "\n");
                }
            }
        } else {
            while ((s = bufferedReader.readLine()) != null) {
                for (int j = 0; j < oldWords.size(); j++) {
                    bufferedWriter.write(s + "\n");
                }
            }
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    public static void append(String from, String to, List<String> tags, List<String> contents) throws Exception {
        FileReader fileReader = new FileReader(from);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        createFile(to);
        FileWriter fileWriter = new FileWriter(to);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String s;
        if (tags != null) {
            while ((s = bufferedReader.readLine()) != null) {
                for (int j = 0; j < tags.size(); j++) {
                    s+=contents.get(j);
                    bufferedWriter.write(s + "\n");
                }
            }
        } else {
            while ((s = bufferedReader.readLine()) != null) {
                for (int j = 0; j < tags.size(); j++) {
                    bufferedWriter.write(s + "\n");
                }
            }
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    public static void changeAndAppend(String from, String to, String pack, List<String> oldWord, List<String> newWord, List<String> position, List<String> content) throws Exception {
        FileReader fileReader = new FileReader(from);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        createFile(to);
        FileWriter fileWriter = new FileWriter(to);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String s;
        s = bufferedReader.readLine();
        bufferedWriter.write("package " + pack + ";\n");
        if (position != null) {
            while ((s = bufferedReader.readLine()) != null) {
                for (int j = 0; j < oldWord.size(); j++) {
                    s = s.replaceAll(oldWord.get(j), newWord.get(j));
                }
                for (int j = 0; j < position.size(); j++) {
                    if (s.contains(position.get(j))) {
                        s += content.get(j);
                        break;
                    }
                }
                bufferedWriter.write(s + "\n");
            }
        } else {
            while ((s = bufferedReader.readLine()) != null) {
                for (int j = 0; j < oldWord.size(); j++) {
                    s = s.replaceAll(oldWord.get(j), newWord.get(j));
                }
                bufferedWriter.write(s + "\n");
            }
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

}
