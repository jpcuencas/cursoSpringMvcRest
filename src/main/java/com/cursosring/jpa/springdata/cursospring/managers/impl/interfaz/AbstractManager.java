package com.cursosring.jpa.springdata.cursospring.managers.impl.interfaz;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * The type AbstractManager.
 *
 * @param <T> the type parameter
 * @param <K> the type parameter
 */
public abstract class AbstractManager<T, K> {
    /**
     * The constant LOGGER.
     */
    protected final Logger LOGGER = LogManager.getLogger(getClass());
    
    private CrudRepository<T, K> repository;
    private Class<T> clazz;
    
    protected AbstractManager() {
    
    }
    
    public abstract JpaRepository<T, K> getRepository();
    
    /**
     * Create t.
     *
     * @param t the t
     * @return boolean
     */
    public T save(T t) {
        return this.getRepository().save(t);
    }
    
    /**
     * Delete boolean.
     *
     * @param t the t
     * @return the boolean
     */
    public void delete(T t) {
        this.getRepository().delete(t);
    }
    
    /**
     * Find t.
     *
     * @param id the id
     * @return the t
     */
    public Optional<T> get(K id) {
        return this.getRepository().findById(id);
    }
    
    // public abstract List<T> findAll();
    
    /**
     * Find all list.
     *
     * @return the list
     */
    public Iterable<T> findAll() {
        return this.getRepository().findAll();
    }
    
    public Long count() {
        return this.getRepository().count();
    }
}