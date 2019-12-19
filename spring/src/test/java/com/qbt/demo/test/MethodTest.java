package com.qbt.demo.test;

import com.qbt.demo.method.SymmetricEncoder;
import org.junit.Test;

public class MethodTest {
    @Test
    public void name() {
        String s = SymmetricEncoder.AESEncode("eee", "adsf");
        System.out.println(s);
    }
}
