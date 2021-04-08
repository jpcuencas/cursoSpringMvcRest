package com.cursosring.jpa.springdata.cursospring.managers;

import com.cursosring.jpa.springdata.cursospring.entities.Bill;

import java.util.List;
import java.util.Optional;

public interface IBillManager {
    List<Bill> findBillByProductAndQuatityGtaterThan(Long secProcut, Integer quarity);
    
    List<Bill> findBillByClientId(Long secBill);
    
    Iterable<Bill> findAll();
    
    Long count();
    
    Optional<Bill> get(Long id);
    
    Bill save(Bill bill);
    
    void delete(Bill bill);
    
}
