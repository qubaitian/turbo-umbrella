package com.qbt.demo.crud;

import com.qbt.demo.MockStarter;
import com.qbt.demo.template.domain.Contract;
import com.yhhl.ebo.commom.persistence.Repository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.qbt.demo.method.PrivateUtil.getter;
import static com.qbt.demo.method.PrivateUtil.toStr;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MockStarter.class)
public class TestApplicationTests {

    @Autowired
    Repository<Contract> contractRepository;

    @Test
    public void testContractRepository() throws Exception {
        contractRepository.add(new Contract());
        Contract contract = new Contract();
        contractRepository.add(contract);
        contractRepository.add(new Contract());
        Long id = (Long) getter(contract, "id");
        Contract contract1 = contractRepository.findById(id);
        System.out.println("findById");
        toStr(contract1);
        contractRepository.delete(contract1);
        Contract contract2 = contractRepository.findById(id);
        toStr(contract2);
        List<Contract> all = contractRepository.findAll(null);
        for (Contract contract3 : all) {
            toStr(contract3);
        }
    }

}
