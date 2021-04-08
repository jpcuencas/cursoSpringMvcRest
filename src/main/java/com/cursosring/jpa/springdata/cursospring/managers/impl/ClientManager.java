package com.cursosring.jpa.springdata.cursospring.managers.impl;

import com.cursosring.jpa.springdata.cursospring.entities.Client;
import com.cursosring.jpa.springdata.cursospring.managers.IClientManager;
import com.cursosring.jpa.springdata.cursospring.managers.impl.interfaz.AbstractManager;
import com.cursosring.jpa.springdata.cursospring.repositories.IClientRepository;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientManager extends AbstractManager<Client, Long> implements IClientManager {
    
    @Autowired
    private IClientRepository repository;
    private static final Logger LOGGER = LogManager.getLogger(ClientManager.class);
    
    public IClientRepository getRepository() {
        return this.repository;
    }
    
    public Client findByEmail(String email) {
        return this.repository.findByEmail(email);
    }
    
    public List<Client> findByNameAndSurnameIgnoreCase(String name, String surname) {
        return this.repository.findByNameAndSurnameIgnoreCase(name, surname);
    }
    
    public List<Client> findBySurnameOrderByNameAsc(String name) {
        return this.repository.findBySurnameOrderByNameAsc(name);
    }
}
