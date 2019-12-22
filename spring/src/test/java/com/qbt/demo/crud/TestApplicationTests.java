package com.qbt.demo.crud;

import com.qbt.demo.MockStarter;
import com.qbt.demo.file.Apple;
import com.qbt.demo.file.Bear;
import com.qbt.demo.method.SimpleReflect;
import com.qbt.demo.template.Contract;
import com.yhhl.ebo.commom.persistence.Repository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MockStarter.class)
public class TestApplicationTests {


    @Autowired
    Repository<Apple> appleRepository;

    @Test
    public void testAppleRepository() throws Exception {
        appleRepository.add(new Apple());
        Apple apple = new Apple();
        appleRepository.add(apple);
        appleRepository.add(new Apple());
        Long id = (Long) SimpleReflect.getter(apple, "id");
        Apple apple1 = appleRepository.findById(id);
        SimpleReflect.toStr(apple1);
        appleRepository.delete(apple1);
        Apple apple2 = appleRepository.findById(id);
        SimpleReflect.toStr(apple2);
        List<Apple> all = appleRepository.findAll(null);
        for (Apple apple3 : all) {
            SimpleReflect.toStr(apple3);
        }
    }


    @Autowired
    Repository<Contract> contractRepository;

    @Test
    public void testContractRepository() throws Exception {
        contractRepository.add(new Contract());
        Contract contract = new Contract();
        contractRepository.add(contract);
        contractRepository.add(new Contract());
        Long id = (Long) SimpleReflect.getter(contract, "id");
        Contract contract1 = contractRepository.findById(id);
        System.out.println("findById");
        SimpleReflect.toStr(contract1);
        contractRepository.delete(contract1);
        Contract contract2 = contractRepository.findById(id);
        SimpleReflect.toStr(contract2);
        List<Contract> all = contractRepository.findAll(null);
        for (Contract contract3 : all) {
            SimpleReflect.toStr(contract3);
        }
    }

}
