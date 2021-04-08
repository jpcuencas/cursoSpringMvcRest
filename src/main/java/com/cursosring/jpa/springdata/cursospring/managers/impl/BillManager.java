package com.cursosring.jpa.springdata.cursospring.managers.impl;

import com.cursosring.jpa.springdata.cursospring.entities.Bill;
import com.cursosring.jpa.springdata.cursospring.managers.IBillManager;
import com.cursosring.jpa.springdata.cursospring.managers.impl.interfaz.AbstractManager;
import com.cursosring.jpa.springdata.cursospring.repositories.IBillRepository;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillManager extends AbstractManager<Bill, Long> implements IBillManager {
    
    @Autowired
    private IBillRepository repository;
    private static final Logger LOGGER = LogManager.getLogger(BillManager.class);
    
    public IBillRepository getRepository() {
        return this.repository;
    }
    
    /**/
    public List<Bill> findBillByProductAndQuatityGtaterThan(Long secProcut, Integer quarity) {
        return this.repository.findBillByProductAndQuatityGtaterThan(secProcut, quarity);
        
    }
    
    public List<Bill> findBillByClientId(Long secClient) {
        return this.repository.findBillByClientId(secClient);
        
    }
    /**/
}