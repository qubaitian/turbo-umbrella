//package com.qbt.demo.test;
//
//import com.qbt.test.repotemplate.Contract;
//import com.qbt.test.testTemplate.Apple;
//import com.yhhl.ebo.commom.persistence.Repository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
//import static com.qbt.test.mock.MockUtil.getter;
//import static com.qbt.test.mock.MockUtil.toStr;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = MockStarter.class)
//public class TestApplicationTests {
//
//    @Autowired
//    Repository<Apple> appleRepository;
//
//    @Test
//    public void testAppleRepository() throws Exception {
//        appleRepository.add(new Apple());
//        Apple apple = new Apple();
//        appleRepository.add(apple);
//        appleRepository.add(new Apple());
//        Long id = (Long) getter(apple, "id");
//        Apple apple1 = appleRepository.findById(id);
//        toStr(apple1);
//        appleRepository.delete(apple1);
//        Apple apple2 = appleRepository.findById(id);
//        toStr(apple2);
//        List<Apple> all = appleRepository.findAll(null);
//        for (Apple apple3 : all) {
//            toStr(apple3);
//        }
//    }
//
//    @Autowired
//    Repository<Contract> contractRepository;
//
//    @Test
//    public void testContractRepository() throws Exception {
//        contractRepository.add(new Contract());
//        Contract contract = new Contract();
//        contractRepository.add(contract);
//        contractRepository.add(new Contract());
//        Long id = (Long) getter(contract, "id");
//        Contract contract1 = contractRepository.findById(id);
//        toStr(contract1);
//        contractRepository.delete(contract1);
//        Contract contract2 = contractRepository.findById(id);
//        toStr(contract2);
//        List<Contract> all = contractRepository.findAll(null);
//        for (Contract contract3 : all) {
//            toStr(contract3);
//        }
//    }
//
//}
