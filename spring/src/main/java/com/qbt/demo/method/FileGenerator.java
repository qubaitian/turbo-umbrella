package com.qbt.demo.method;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

public class FileGenerator {
    
    public static void changeAndAppend(String from, String to, String pack, List<String> oldWord, List<String> newWord, List<String> position, List<String> content) throws Exception {
        FileReader fileReader = new FileReader(from);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        PrivateUtil.createFile(to);
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
