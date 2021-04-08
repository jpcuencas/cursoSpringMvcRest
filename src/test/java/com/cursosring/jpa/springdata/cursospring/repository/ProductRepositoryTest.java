package com.cursosring.jpa.springdata.cursospring.repository;

import com.cursosring.jpa.springdata.cursospring.entities.Product;
import com.cursosring.jpa.springdata.cursospring.repositories.IProductRepository;
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
public class ProductRepositoryTest {
    
    @Autowired
    private IProductRepository productRepository;
    
    @Test
    public void testFindAll() {
        List<Product> products = productRepository.findAll();
        if (products.isEmpty()) {
            Assert.fail();
        }
    }
    
    @Test
    public void testGet() {
        Product product = productRepository.getOne(1L);
        if (product.getId() == null) {
            Assert.fail();
        }
    }
    
    @Test
    public void testDelete() {
        Product product = productRepository.getOne(1L);
        productRepository.delete(product);
        product = productRepository.getOne(1L);
        if (product.getId() == null) {
            Assert.fail();
        }
    }
}
