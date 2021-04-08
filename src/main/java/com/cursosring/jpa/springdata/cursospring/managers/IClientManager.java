package com.cursosring.jpa.springdata.cursospring.managers;

import com.cursosring.jpa.springdata.cursospring.entities.Client;

import java.util.List;
import java.util.Optional;

public interface IClientManager {
    Client findByEmail(String email);
    
    List<Client> findByNameAndSurnameIgnoreCase(String name, String surname);
    
    List<Client> findBySurnameOrderByNameAsc(String name);
    
    Iterable<Client> findAll();
    
    Long count();
    
    Optional<Client> get(Long id);
    
    Client save(Client client);
    
    void delete(Client client);
    
}
