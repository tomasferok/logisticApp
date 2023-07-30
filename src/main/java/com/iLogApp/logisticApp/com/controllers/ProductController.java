package com.iLogApp.logisticApp.com.controllers;

import com.iLogApp.logisticApp.com.entities.Product;
import com.iLogApp.logisticApp.com.services.IService.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    IProductService iProductService;

    @PostMapping
    public Optional<Product> saveProduct(@RequestBody Product product){
        return iProductService.save(product);
    }

    @GetMapping("/getPage/{numberPage}")
    public Optional<Page<Product>>getAllProducts (@PathVariable int numberPage){
        return iProductService.getAll(numberPage);
    }
    @GetMapping("/{id}")
    public Optional<Product>getProductById (@PathVariable Long id){
        return iProductService.getById(id);
    }
    @DeleteMapping("/{id}")
    public Optional<?>deleteProductById(@PathVariable Long id){
        return iProductService.deleteById(id);
    }

}
