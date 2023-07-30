package com.iLogApp.logisticApp.com.services.IService;

import com.iLogApp.logisticApp.com.entities.Category;
import com.iLogApp.logisticApp.com.entities.Product;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ICategoryService {
    Optional<Page<Category>> getAll(int numberPage);
    Optional<Category>getById(Long id);
    Optional<?>deleteById(Long id);
    Optional<Category> save(Category category);

}
