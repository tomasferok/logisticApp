package com.iLogApp.logisticApp.com.controllers;

import com.iLogApp.logisticApp.com.entities.Category;
import com.iLogApp.logisticApp.com.services.IService.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    ICategoryService iCategoryService;

    @GetMapping("/getPage/{numberPage}")
    public Optional<?> getAllCategories (@PathVariable int numberPage){
        return iCategoryService.getAll(numberPage);
    }

    @GetMapping("/{idCategory}")
    public Optional<Category> getCategoryById(@PathVariable Long idCategory){

        return iCategoryService.getById(idCategory);
    }
    @PostMapping
    public Optional<Category> saveProduct(@RequestBody Category category){
        return iCategoryService.save(category);
    }

    @DeleteMapping("/{id}")
    public Optional<?>deleteCategoryById(@PathVariable Long id){
        return iCategoryService.deleteById(id);
    }


}
