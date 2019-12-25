package com.qbt.demo.method.file;

import java.util.List;

public class AppendImpl implements LineGenerator {
    @Override
    public String change(String line, List<Term> terms) {
        for (Term term : terms) {
            if (line.contains(term.getWhere())) {
                line += "\n"+term.getContent();
            }
        }
        return line;
    }
}
