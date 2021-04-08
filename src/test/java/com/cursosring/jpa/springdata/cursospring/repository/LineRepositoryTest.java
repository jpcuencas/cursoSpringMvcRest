package com.cursosring.jpa.springdata.cursospring.repository;

import com.cursosring.jpa.springdata.cursospring.entities.Line;
import com.cursosring.jpa.springdata.cursospring.repositories.ILineRepository;
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
public class LineRepositoryTest {
    
    @Autowired
    private ILineRepository lineRepository;
    
    @Test
    public void testFindAll() {
        List<Line> lines = lineRepository.findAll();
        if (lines.isEmpty()) {
            Assert.fail();
        }
    }
    
    @Test
    public void testGet() {
        Line line = lineRepository.getOne(1L);
        if (line.getId() == null) {
            Assert.fail();
        }
    }
    
    @Test
    public void testDelete() {
        Line line = lineRepository.getOne(1L);
        lineRepository.delete(line);
        line = lineRepository.getOne(1L);
        if (line.getId() == null) {
            Assert.fail();
        }
    }
}
