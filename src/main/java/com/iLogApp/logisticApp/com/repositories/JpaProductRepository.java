package com.iLogApp.logisticApp.com.repositories;

import com.iLogApp.logisticApp.com.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaProductRepository extends JpaRepository<Product, Long> {
    Product findByNameProduct(String nameProduct);

}
