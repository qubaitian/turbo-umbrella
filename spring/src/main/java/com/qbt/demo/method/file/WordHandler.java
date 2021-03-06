package com.qbt.demo.method.file;

public class WordHandler {

    public static String toLower(String s) {
        char c = s.charAt(0);
        return Character.toLowerCase(c) + s.substring(1);
    }

    public static String toUpper(String s) {
        char c = s.charAt(0);
        return Character.toUpperCase(c) + s.substring(1);
    }

    public static String camelToUnderline(String str) {
        if (str == null || str.trim().isEmpty()) {
            return "";
        }
        int len = str.length();
        StringBuilder sb = new StringBuilder(len);
        sb.append(str.substring(0, 1).toLowerCase());
        for (int i = 1; i < len; i++) {
            char c = str.charAt(i);
            if (Character.isUpperCase(c)) {
                sb.append("_");
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
