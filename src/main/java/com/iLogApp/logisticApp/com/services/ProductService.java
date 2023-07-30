package com.iLogApp.logisticApp.com.services;

import com.iLogApp.logisticApp.com.entities.Product;
import com.iLogApp.logisticApp.com.repositories.JpaProductRepository;
import com.iLogApp.logisticApp.com.services.IService.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    JpaProductRepository jpaProductRepository;

    @Override
    public Optional<Page<Product>> getAll(int numberPage) {
        int pageSize= 10;
        PageRequest page= PageRequest.of(numberPage, pageSize);
        return Optional.of(jpaProductRepository.findAll(page));
    }

    @Override
    public Optional<Product> getById(Long id) {
        if (jpaProductRepository.existsById(id)) {
            Optional<Product> productFinded= jpaProductRepository.findById(id);
            return productFinded;
        }
        return Optional.empty();
    }

    @Override
    public Optional<Product> getByName(String nameProduct) {

        return Optional.empty();
    }

    @Override
    public Optional<?> deleteById(Long id) {
        if (jpaProductRepository.existsById(id)) {
            Optional<Product> productDeleted= jpaProductRepository.findById(id);
            jpaProductRepository.deleteById(id);
            String message = "The product: " + productDeleted.get().getNameProduct() + " has been deleted";
            return Optional.of(message);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Product> save(Product product) {
        return Optional.of(jpaProductRepository.save(product));
    }
}
