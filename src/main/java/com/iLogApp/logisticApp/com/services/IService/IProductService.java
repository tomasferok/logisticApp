package com.iLogApp.logisticApp.com.services.IService;

import com.iLogApp.logisticApp.com.entities.Product;
import org.springframework.data.domain.Page;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface IProductService {
    Optional<Page<Product>> getAll(int numberPage);
    Optional<Product>getById(Long id);
    Optional<Product>getByName(String nameProduct);
    Optional<?>deleteById(Long id);
    Optional<Product> save(Product product);

}
