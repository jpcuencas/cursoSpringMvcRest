package com.cursosring.jpa.springdata.cursospring.repositories;

import com.cursosring.jpa.springdata.cursospring.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClientRepository extends JpaRepository<Client, Long>, JpaSpecificationExecutor<Client> {
    
    Client findByEmail(String email);
    
    List<Client> findByNameAndSurnameIgnoreCase(String name, String surname);
    
    List<Client> findBySurnameOrderByNameAsc(String name);
    
    @Query("SELECT c FROM Client c JOIN FETCH c.bills b WHERE c.id = ?1")
    List<Client> fetchByIdWithClientWithLineWithProduct(Long id);
}
