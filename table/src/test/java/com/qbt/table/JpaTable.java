package com.qbt.table;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaTableStarter.class)
public class JpaTable {

    @Test
    public void say() {
        System.out.println("没表创建,有表update");
    }

}
