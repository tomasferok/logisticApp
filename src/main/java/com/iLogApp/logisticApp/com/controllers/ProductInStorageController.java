package com.iLogApp.logisticApp.com.controllers;

import com.iLogApp.logisticApp.com.entities.ProductInStorage;
import com.iLogApp.logisticApp.com.services.IService.IProductInStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/productsInStorage")
public class ProductInStorageController {
    @Autowired
    IProductInStorageService iProductInStorageService;

    @GetMapping("/getPage/{numberPage}")
    public Optional<Page<ProductInStorage>> getAllProductsInStorage (@PathVariable int numberPage){
        return iProductInStorageService.getAll(numberPage);
    }
    @PostMapping
    public Optional<?> save(@RequestBody ProductInStorage productInStorage){
        return iProductInStorageService.save(productInStorage);
    }
    @DeleteMapping("/{id}")
    public Optional<?>deleteProductInStorageById(@PathVariable Long id){
        return iProductInStorageService.deleteById(id);
    }
    @GetMapping("/{id}")
    public Optional<ProductInStorage>getProductInStorageById(@PathVariable Long id){
        return iProductInStorageService.getById(id);
    }
}
