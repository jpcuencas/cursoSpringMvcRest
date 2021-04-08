package com.cursosring.jpa.springdata.cursospring.repositories;

import com.cursosring.jpa.springdata.cursospring.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBillRepository extends JpaRepository<Bill, Long>, JpaSpecificationExecutor<Bill> {
    @Query("SELECT b FROM Bill b JOIN FETCH b.lines l JOIN FETCH l.product p WHERE p.id = ?1 and l.quantity = ?2")
    List<Bill> findBillByProductAndQuatityGtaterThan(Long secProcut, Integer quarity);
    
    List<Bill> findBillByClientId(Long secClient);
    
    @Query("SELECT b FROM Bill b JOIN FETCH b.client c JOIN FETCH b.lines l JOIN FETCH l.product WHERE b.id = ?1")
    Bill fetchByIdWithClientWithLineWithProduct(Long id);
    
}