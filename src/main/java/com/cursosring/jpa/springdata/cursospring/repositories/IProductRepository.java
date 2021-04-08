package com.cursosring.jpa.springdata.cursospring.repositories;

import com.cursosring.jpa.springdata.cursospring.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    
    List<Product> findProductByPriceLessThan(Double price);
    
    List<Product> findByPriceLessThanEqual(Double price);
    
}
