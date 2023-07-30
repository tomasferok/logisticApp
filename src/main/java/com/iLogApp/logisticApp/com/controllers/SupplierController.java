package com.iLogApp.logisticApp.com.controllers;
import com.iLogApp.logisticApp.com.entities.Supplier;
import com.iLogApp.logisticApp.com.services.IService.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {
    @Autowired
    ISupplierService iSupplierService;

    @GetMapping("/getPage/{numberPage}")
    public Optional<?> getAllSuppliers (@PathVariable int numberPage){
        return iSupplierService.getAll(numberPage);
    }

    @PostMapping
    public Optional<Supplier> saveStorage(@RequestBody Supplier supplier){
        return iSupplierService.save(supplier);
    }
    @GetMapping("/{id}")
    public Optional<Supplier>getProductInStorageById(@PathVariable Long id){
        return iSupplierService.getById(id);

    }
    @DeleteMapping("/{id}")
    public Optional<?>deleteSupplierById(@PathVariable Long id){
        return iSupplierService.deleteById(id);
    }
}
