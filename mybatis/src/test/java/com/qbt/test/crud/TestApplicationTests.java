package com.qbt.test.crud;

import com.qbt.test.MybatisTestStarter;
import com.qbt.test.mock.SimpleReflect;
import com.qbt.test.template.TemplateEntity;
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
    Repository<TemplateEntity> contractRepository;

    @Test
    public void testContractRepository() throws Exception {
        contractRepository.add(new TemplateEntity());
        TemplateEntity templateEntity = new TemplateEntity();
        contractRepository.add(templateEntity);
        contractRepository.add(new TemplateEntity());
        Long id = (Long) SimpleReflect.getter(templateEntity, "id");
        TemplateEntity templateEntity1 = contractRepository.findById(id);
        System.out.println("findById");
        SimpleReflect.toStr(templateEntity1);
        contractRepository.delete(templateEntity1);
        TemplateEntity templateEntity2 = contractRepository.findById(id);
        SimpleReflect.toStr(templateEntity2);
        List<TemplateEntity> all = contractRepository.findAll(null);
        for (TemplateEntity templateEntity3 : all) {
            SimpleReflect.toStr(templateEntity3);
        }
    }

}
