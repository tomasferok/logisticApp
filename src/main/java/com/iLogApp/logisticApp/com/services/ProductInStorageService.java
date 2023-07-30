package com.iLogApp.logisticApp.com.services;

import com.iLogApp.logisticApp.com.entities.ProductInStorage;
import com.iLogApp.logisticApp.com.entities.Storage;
import com.iLogApp.logisticApp.com.exceptions.InvalidProductCategoryException;
import com.iLogApp.logisticApp.com.helpers.Ihelpers.IProductInStorageHelper;
import com.iLogApp.logisticApp.com.repositories.JpaProductInStorageRepository;
import com.iLogApp.logisticApp.com.services.IService.IProductInStorageService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductInStorageService implements IProductInStorageService {

    @Autowired
    IProductInStorageHelper iProductInStorageHelper;
    @Autowired
    JpaProductInStorageRepository jpaProductInStorageRepository;

    @Override
    public Optional<Page<ProductInStorage>> getAll(int numberPage) {
        int pageSize= 10;
        PageRequest page= PageRequest.of(numberPage, pageSize);
        return Optional.of(jpaProductInStorageRepository.findAll(page));
    }

    @Override
    public Optional<ProductInStorage> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<?> deleteById(Long id) {
        if(jpaProductInStorageRepository.existsById(id)){
            Optional<ProductInStorage> productInStorageDeleted = jpaProductInStorageRepository.findById(id);
            jpaProductInStorageRepository.deleteById(id);
            String message = "The product: " + productInStorageDeleted.get().getNameProduct() + " has been deleted";
            return Optional.of(message);
        }
        return Optional.empty();
    }

    @Override
    public Optional<?> save(ProductInStorage productInStorage) {
        Optional<?> message = Optional.empty();

            iProductInStorageHelper.productInStorageValidations(productInStorage);

            message = iProductInStorageHelper.IfProductNameExistIncreaseAmount(productInStorage);
            if(message.isPresent()){
                return message;
            }
            ProductInStorage productSaved = jpaProductInStorageRepository.save(productInStorage);
            message = Optional.of("The product " + productSaved.getNameProduct() + " has been saved succesfuly");

        return message;
    }

    @Override
    public ProductInStorage findByNameProduct(String nameProductInStorage) {
        ProductInStorage productFinded = jpaProductInStorageRepository.findByNameProduct(nameProductInStorage);
        return productFinded;
    }

    @Override
    public ProductInStorage getByNameAndStorage(String nameProduct, Storage storage) {
        return jpaProductInStorageRepository.findByNameProductAndStorage(nameProduct, storage);
    }
}
