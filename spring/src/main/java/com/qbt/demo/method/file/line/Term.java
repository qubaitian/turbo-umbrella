package com.qbt.demo.method.file.line;

import lombok.Data;

@Data
public class Term {

    private String where;
    private String oldWord;
    private String newWord;
    private String content;

    public Term() {
    }

    public Term(String where, String oldWord, String newWord) {
        this.where = where;
        this.oldWord = oldWord;
        this.newWord = newWord;
    }

    public Term(String where, String content) {
        this.where = where;
        this.content = content;
    }
}
