package com.qbt.demo.test;

import com.qbt.demo.method.file.RepoG;
import org.junit.jupiter.api.Test;

public class RepoGTest {

    RepoG repoG = new RepoG(
            "Candy",
            "candy",
            "C:\\work\\manual\\mybatis\\src\\main\\java\\com\\qbt\\test\\file",
            "com.qbt.test.file",
            "\n" +
                    "    private String name;\n" +
                    "    private String code;",
            "\n"/* +
                    "    private Candy candy;\n" +
                    "    private List<Candy> candies;"*/
    );

    @Test
    void test1() throws Exception {
        repoG.createEntity();
        repoG.createPo();
        repoG.createPoDao();
        repoG.createPoRepository();
        repoG.createPoUtil();
        repoG.createSpecification();
        repoG.createTable();
    }

}
