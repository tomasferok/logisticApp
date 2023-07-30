package com.iLogApp.logisticApp.com.services.IService;

import com.iLogApp.logisticApp.com.entities.ProductInStorage;
import com.iLogApp.logisticApp.com.entities.Storage;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.Optional;

public interface IProductInStorageService {
    Optional<Page<ProductInStorage>> getAll(int numberPage);
    Optional<ProductInStorage>getById(Long id);
    Optional<?>deleteById(Long id);
    Optional<?> save(ProductInStorage productInStorage);

    ProductInStorage findByNameProduct(String nameProductInStorage);
    ProductInStorage getByNameAndStorage(String nameProduct, Storage storage);
}
