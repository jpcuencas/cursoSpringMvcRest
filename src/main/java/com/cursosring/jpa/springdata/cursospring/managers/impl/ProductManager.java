package com.cursosring.jpa.springdata.cursospring.managers.impl;

import com.cursosring.jpa.springdata.cursospring.entities.Product;
import com.cursosring.jpa.springdata.cursospring.managers.IProductManager;
import com.cursosring.jpa.springdata.cursospring.managers.impl.interfaz.AbstractManager;
import com.cursosring.jpa.springdata.cursospring.repositories.IProductRepository;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager extends AbstractManager<Product, Long> implements IProductManager {
    
    @Autowired
    private IProductRepository repository;
    private static final Logger LOGGER = LogManager.getLogger(ProductManager.class);
    
    public IProductRepository getRepository() {
        return this.repository;
    }
    
    public List<Product> findProductByPriceLessThan(Double price) {
        return this.repository.findProductByPriceLessThan(price);
    }
    
}
