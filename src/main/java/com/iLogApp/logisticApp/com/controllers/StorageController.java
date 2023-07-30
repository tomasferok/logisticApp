package com.iLogApp.logisticApp.com.controllers;

import com.iLogApp.logisticApp.com.entities.ProductInStorage;
import com.iLogApp.logisticApp.com.entities.Storage;
import com.iLogApp.logisticApp.com.services.IService.IStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/storages")
public class StorageController {
    @Autowired
    IStorageService iStorageService;

    @GetMapping("/getPage/{numberPage}")
    public Optional<?> getAllStorages (@PathVariable int numberPage){
        return iStorageService.getAll(numberPage);
    }
    @PostMapping
    public Optional<Storage> saveStorage(@RequestBody Storage storage){
        return iStorageService.save(storage);
    }
    @DeleteMapping("/{id}")
    public Optional<?>deleteStorageById(@PathVariable Long id){
        return iStorageService.deleteById(id);
    }
    @GetMapping("/{id}")
    public Optional<Storage>getProductInStorageById(@PathVariable Long id){
        return iStorageService.getById(id);
    }
}
