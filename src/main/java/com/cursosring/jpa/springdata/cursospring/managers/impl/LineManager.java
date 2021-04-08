package com.cursosring.jpa.springdata.cursospring.managers.impl;

import com.cursosring.jpa.springdata.cursospring.entities.Line;
import com.cursosring.jpa.springdata.cursospring.managers.ILineManager;
import com.cursosring.jpa.springdata.cursospring.managers.impl.interfaz.AbstractManager;
import com.cursosring.jpa.springdata.cursospring.repositories.ILineRepository;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LineManager extends AbstractManager<Line, Long> implements ILineManager {
    
    @Autowired
    private ILineRepository repository;
    private static final Logger LOGGER = LogManager.getLogger(LineManager.class);
    
    public ILineRepository getRepository() {
        return this.repository;
    }
    
}
