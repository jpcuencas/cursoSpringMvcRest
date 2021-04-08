package com.cursosring.jpa.springdata.cursospring.managers;

import com.cursosring.jpa.springdata.cursospring.entities.Product;

import java.util.List;
import java.util.Optional;

public interface IProductManager {
    
    List<Product> findProductByPriceLessThan(Double price);
    
    Iterable<Product> findAll();
    
    Long count();
    
    Optional<Product> get(Long id);
    
    Product save(Product product);
    
    void delete(Product product);
    
}
