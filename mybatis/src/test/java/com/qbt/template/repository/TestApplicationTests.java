package com.qbt.template.repository;

import com.qbt.template.MybatisTestStarter;
import com.qbt.template.mock.SimpleReflect;
import com.qbt.template.repository.slim.Template;
import com.yhhl.ebo.commom.persistence.Repository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisTestStarter.class)
public class TestApplicationTests {

    @Autowired
    Repository<Template> templateRepository;

    @Test
    public void testTemplateRepository() throws Exception {
        templateRepository.add(new Template());
        Template template = new Template();
        templateRepository.add(template);
        templateRepository.add(new Template());
        Long id = (Long) SimpleReflect.getter(template, "id");
        Template template1 = templateRepository.findById(id);
        SimpleReflect.toStr(template1);
        templateRepository.delete(template1);
        Template template2 = templateRepository.findById(id);
        SimpleReflect.toStr(template2);
        List<Template> all = templateRepository.findAll(null);
        for (Template template3 : all) {
            SimpleReflect.toStr(template3);
        }
    }
}
