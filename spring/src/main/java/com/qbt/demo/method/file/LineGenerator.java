package com.qbt.demo.method.file;

import com.qbt.demo.method.Term;

import java.util.List;

public interface LineGenerator {
    String change(String line, List<Term> terms);
}
