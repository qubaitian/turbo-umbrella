package com.qbt.demo.method.file.line;

import java.util.List;

public class WriteImpl implements LineGenerator {
    @Override
    public String change(String line, List<Term> terms) {
        for (Term term : terms) {
            if (line.contains(term.getWhere())) {
                line = term.getContent();
            }
        }
        return line;
    }
}
