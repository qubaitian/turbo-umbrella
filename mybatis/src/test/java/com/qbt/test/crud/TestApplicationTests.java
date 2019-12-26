package com.qbt.test.crud;

import com.qbt.test.MybatisTestStarter;
import com.qbt.test.file.Bear;
import com.qbt.test.file.Candy;
import com.qbt.test.file.Dear;
import com.qbt.test.mock.SimpleReflect;
import com.yhhl.ebo.commom.persistence.Repository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisTestStarter.class)
public class TestApplicationTests {

    Logger logger = LoggerFactory.getLogger(TestApplicationTests.class);

    @Autowired
    Repository<Candy> candyRepository;

    @Test
    public void testCandyRepository() throws Exception {
        Candy candy = new Candy(
                null,
                null,
                "name",
                "code"
        );
        candyRepository.add(candy);
        Long id = (Long) SimpleReflect.getter(candy, "id");
        Candy byId = candyRepository.findById(id);
        SimpleReflect.toStr(byId);
    }


    @Autowired
    Repository<Dear> dearRepository;

    @Test
    public void testBearRepository() throws Exception {
        Dear dear=new Dear();
        Candy candy = new Candy(
                null,
                null,
                "name",
                "code"
        );
        SimpleReflect.setter(dear,"candy",candy);
        List<Candy> list=new ArrayList<>();
        list.add(candy);
        SimpleReflect.setter(dear,"candies",list);
        dearRepository.add(dear);
        Long id = (Long) SimpleReflect.getter(dear, "id");
        Dear byId = dearRepository.findById(id);
        SimpleReflect.toStr(byId);
    }




}
