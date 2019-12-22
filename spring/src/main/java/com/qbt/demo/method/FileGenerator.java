package com.qbt.demo.method;

import org.springframework.util.StringUtils;

import java.io.*;
import java.util.List;

public class FileGenerator {

    private static String tempDir = "C:\\temp";
    private static String tempFile = "C:\\temp\\temp";

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

    public static void append(String fileName, List<Term> terms) throws Exception {
        appendAndCreate(fileName, tempFile, terms);
        appendAndCreate(tempFile, fileName, null);
    }

    public static void appendAndCreate(String from, String to, List<Term> terms) throws Exception {
        FileReader fileReader = new FileReader(from);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        createFile(to);
        FileWriter fileWriter = new FileWriter(to);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String s;
        if (terms != null) {
            while ((s = bufferedReader.readLine()) != null) {
                for (Term term : terms) {
                    if (s.contains(term.getWhere())) {
                        s+=term.getContent();
                    }
                }
                bufferedWriter.write(s + "\n");
            }
        } else {
            while ((s = bufferedReader.readLine()) != null) {
                bufferedWriter.write(s + "\n");
            }
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    public static void update(String fileName, List<Term> terms) throws Exception {
        updateAndCreate(fileName, tempFile, terms);
        updateAndCreate(tempFile, fileName, null);
    }

    public static void updateAndCreate(String from, String to, List<Term> terms) throws Exception {
        FileReader fileReader = new FileReader(from);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        createFile(to);
        FileWriter fileWriter = new FileWriter(to);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String s;
        if (terms != null) {
            while ((s = bufferedReader.readLine()) != null) {
                for (Term term : terms) {
                    if (StringUtils.hasText(term.getWhere())) {
                        s = s.replaceAll(term.getOldWord(), term.getNewWord());
                    } else {
                        if (s.contains(term.getOldWord())) {
                            s = s.replaceAll(term.getOldWord(), term.getNewWord());
                        }
                    }
                }
                bufferedWriter.write(s + "\n");
            }
        } else {
            while ((s = bufferedReader.readLine()) != null) {
                bufferedWriter.write(s + "\n");
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
