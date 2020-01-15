package com.qbt.demo.test;

import com.qbt.demo.method.file.RepoG;
import org.junit.jupiter.api.Test;

public class RepoGTest {

    @Test
    void test1() throws Exception {
        RepoG repoG = new RepoG(
                "Invoice",
                "invoice",
                "C:\\work\\ebo\\ebo-contract\\src\\main\\java\\com\\yhhl\\ebo\\business\\repository\\invoice",
                "com.yhhl.ebo.business.repository.invoice",
                "\n" +
                        "    private Long paymentId;\n" +
                        "    private String companyName;\n" +
                        "    private String taxpayerNumber;\n" +
                        "    private String address;\n" +
                        "    private String phone;\n" +
                        "    private String openBank;\n" +
                        "    private String bankAccount;\n" +
                        "    private String content;\n" +
                        "    private BigDecimal amount;\n" +
                        "    private Double taxRate;\n" +
                        "    private BigDecimal taxAmount;",
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
