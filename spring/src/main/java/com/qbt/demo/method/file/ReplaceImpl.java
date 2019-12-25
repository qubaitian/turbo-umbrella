package com.qbt.demo.method.file;

import org.springframework.util.StringUtils;

import java.util.List;

public class ReplaceImpl implements LineGenerator {
    @Override
    public String change(String line, List<Term> terms) {
        for (Term term : terms) {
            if (StringUtils.hasText(term.getWhere())) {
                line = line.replaceAll(term.getOldWord(), term.getNewWord());
            } else {
                if (line.contains(term.getOldWord())) {
                    line = line.replaceAll(term.getOldWord(), term.getNewWord());
                }
            }
        }
        return line;
    }
}