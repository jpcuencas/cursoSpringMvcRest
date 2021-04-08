package com.cursosring.jpa.springdata.cursospring.repository;

import com.cursosring.jpa.springdata.cursospring.entities.Client;
import com.cursosring.jpa.springdata.cursospring.repositories.IClientRepository;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextBeforeModesTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ClientRepositoryTest {
    
    @Autowired
    private IClientRepository clientRepository;
    
    @Test
    public void testFindAll() {
        List<Client> clients = clientRepository.findAll();
        if (clients.isEmpty()) {
            Assert.fail();
        }
    }
    
    @Test
    public void testGet() {
        Client client = clientRepository.getOne(1L);
        if (client.getId() == null) {
            Assert.fail();
        }
    }
    
    @Test
    public void testDelete() {
        Client client = clientRepository.getOne(1L);
        clientRepository.delete(client);
        client = clientRepository.getOne(1L);
        if (client.getId() == null) {
            Assert.fail();
        }
    }
}
