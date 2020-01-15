package com.qbt.demo.test;

import com.qbt.demo.method.file.RepositoryG;
import org.junit.jupiter.api.Test;

public class testGG {

    @Test
    void createTable() {
        RepositoryG repositoryG = new RepositoryG();

        repositoryG.setOldWhere("C:\\work\\manual\\mybatis\\src\\main\\java\\com\\qbt\\template\\repository\\slim");
        repositoryG.setOldName("Template");
        repositoryG.setNewWhere("C:\\work\\ebo\\ebo-contract\\src\\main\\java\\com\\yhhl\\ebo\\business\\repository\\receipt");
        repositoryG.setNewName("Receipt");
        repositoryG.setTableName("receipt");
        repositoryG.setEntity("C:\\work\\ebo\\ebo-contract\\src\\main\\java\\com\\yhhl\\ebo\\business\\domain\\receipt\\Receipt.java");
        repositoryG.afterSetter();

        repositoryG.createTable();
//        repositoryG.createAnEntity();
        repositoryG.createDao();
        repositoryG.createRepository();
//        repositoryG.createSpecification();
    }

}
