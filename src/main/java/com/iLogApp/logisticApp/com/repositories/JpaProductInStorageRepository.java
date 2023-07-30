package com.iLogApp.logisticApp.com.repositories;

import com.iLogApp.logisticApp.com.entities.ProductInStorage;
import com.iLogApp.logisticApp.com.entities.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaProductInStorageRepository extends JpaRepository<ProductInStorage, Long> {
    ProductInStorage findByNameProductAndStorage(String nameProduct, Storage storage);
    ProductInStorage findByNameProduct(String nameProduct);
}
