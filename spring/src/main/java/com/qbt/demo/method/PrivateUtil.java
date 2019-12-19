package com.qbt.demo.method;

import java.io.*;

public class PrivateUtil {

    public static void insertContent(String filePath, String content, Long position) throws Exception {
        RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, "rw");
        randomAccessFile.seek(position);
        byte[] b = new byte[8];
        StringBuilder suffix = new StringBuilder();
        int len;
        while ((len = randomAccessFile.read(b)) != -1) {
            suffix.append(new String(b, 0, len));
        }
        randomAccessFile.seek(position);
        randomAccessFile.write(content.getBytes());
        randomAccessFile.write(suffix.toString().getBytes());
        randomAccessFile.close();
    }

}
