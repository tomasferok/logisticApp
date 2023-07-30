package com.iLogApp.logisticApp.com.services;

import com.iLogApp.logisticApp.com.entities.Category;
import com.iLogApp.logisticApp.com.repositories.JpaCategoryRepository;
import com.iLogApp.logisticApp.com.services.IService.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    JpaCategoryRepository jpaCategoryRepository;

    @Override
    public Optional<Page<Category>> getAll(int numberPage) {
        int pageSize = 10;
        PageRequest page= PageRequest.of(numberPage, pageSize);
        return Optional.of(jpaCategoryRepository.findAll(page));
    }

    @Override
    public Optional<Category> getById(Long id) {
        if(jpaCategoryRepository.existsById(id)){
                Optional<Category> categoryFinded = jpaCategoryRepository.findById(id);
                return categoryFinded;
        }
        return Optional.empty();
    }

    @Override
    public Optional<?> deleteById(Long id) {
        if(jpaCategoryRepository.existsById(id)){
            Optional<Category> categoryDeleted = jpaCategoryRepository.findById(id);
            jpaCategoryRepository.deleteById(id);
            String message = "The category: " + categoryDeleted.get().getNameCat() +" has been deleted";
            return Optional.of(message);
        }
       return Optional.empty();


    }

    @Override
    public Optional<Category> save(Category category) {
        return Optional.of(jpaCategoryRepository.save(category));
    }
}
