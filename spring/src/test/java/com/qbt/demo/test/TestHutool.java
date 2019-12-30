package com.qbt.demo.test;

import cn.hutool.core.util.StrUtil;
import org.junit.jupiter.api.Test;

public class TestHutool {
    @Test
    void test1() {
        String[] s = StrUtil.split("123 345 435", " ");
        for (String s1 : s) {
            System.out.println(s1);
        }
        String format = StrUtil.format("{}w{o} di{}", "1", "2", "3");
        System.out.println(format);
    }
}
