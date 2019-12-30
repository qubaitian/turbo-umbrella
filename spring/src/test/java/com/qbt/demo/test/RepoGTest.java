package com.qbt.demo.test;

import com.qbt.demo.method.file.RepoG;
import org.junit.jupiter.api.Test;

public class RepoGTest {

    @Test
    void test1() throws Exception {
        RepoG repoG = new RepoG(
                "FormalContract",
                "formal_contract",
                "C:\\work\\ebo\\ebo-contract\\src\\main\\java\\com\\yhhl\\ebo\\business\\repository\\contract",
                "com.yhhl.ebo.business.repository.contract",
                "\n" +
                        "    private Integer tag;\n" +
                        "    private String partyA;\n" +
                        "    private String partyB;\n" +
                        "    private Long organizationId;\n" +
                        "    private String contractNumber;\n" +
                        "    private String contractName;\n" +
                        "    private BigDecimal contractAmount;\n" +
                        "    private Integer contractStatus;\n" +
                        "    private Long creatorId;\n" +
                        "    private Long originalId;",
                "\n"/* +
                    "    private Candy candy;\n" +
                    "    private List<Candy> candies;"*/
        );
//        repoG.createEntity();
        repoG.createPo();
        repoG.createPoDao();
        repoG.createPoRepository();
        repoG.createPoUtil();
        repoG.createSpecification();
        repoG.createTable();
    }

    @Test
    void test2() throws Exception {
        RepoG repoG = new RepoG(
                "Bear",
                "bear",
                "C:\\work\\manual\\mybatis\\src\\main\\java\\com\\qbt\\test\\file",
                "com.qbt.test.file",
                "\n" +
                        "    private String name;\n" +
                        "    private String code;",
                "\n" +
                        "    private Candy candy;\n" +
                        "    private List<Candy> candies;"
        );
        repoG.createEntity();
        repoG.createPo();
        repoG.createPoDao();
        repoG.createPoRepository();
        repoG.createPoUtil();
        repoG.createSpecification();
        repoG.createTable();
    }

    @Test
    void test3() throws Exception {
        RepoG repoG = new RepoG(
                "Dear",
                "dear",
                "C:\\work\\manual\\mybatis\\src\\main\\java\\com\\qbt\\test\\file",
                "com.qbt.test.file",
                "\n" +
                        "    private String name;\n" +
                        "    private String code;",
                "\n" +
                        "    private Candy candy;\n" +
                        "    private List<Candy> candies;"
        );
        repoG.createEntity();
        repoG.createPo();
        repoG.createPoDao();
        repoG.createPoRepository();
        repoG.createPoUtil();
        repoG.createSpecification();
        repoG.createTable();
    }
}
