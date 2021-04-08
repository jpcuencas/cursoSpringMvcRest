package com.cursosring.jpa.springdata.cursospring.managers;

import com.cursosring.jpa.springdata.cursospring.entities.Line;

import java.util.Optional;

public interface ILineManager {
    
    Iterable<Line> findAll();
    
    Long count();
    
    Optional<Line> get(Long id);
    
    Line save(Line line);
    
    void delete(Line line);
    
}
