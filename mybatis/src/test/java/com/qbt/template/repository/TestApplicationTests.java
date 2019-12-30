package com.qbt.template.repository;

import com.qbt.template.MybatisTestStarter;
import com.qbt.template.mock.SimpleReflect;
import com.qbt.template.repository.append.Candy;
import com.qbt.template.test.Football;
import com.yhhl.ebo.commom.persistence.Repository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisTestStarter.class)
public class TestApplicationTests {

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
    Repository<Football> footballRepository;

    @Test
    public void testFootball() throws IllegalAccessException {
        Football football=new Football(
                null,
                null,
                "name",
                "code"
        );
        footballRepository.add(football);
        Long id =(Long) SimpleReflect.getter(football,"id");
        Football byId = footballRepository.findById(id);
        SimpleReflect.toStr(byId);
    }
}
