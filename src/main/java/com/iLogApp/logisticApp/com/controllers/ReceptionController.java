package com.iLogApp.logisticApp.com.controllers;

import com.iLogApp.logisticApp.com.entities.ProductInStorage;
import com.iLogApp.logisticApp.com.entities.Reception;
import com.iLogApp.logisticApp.com.entities.Supplier;
import com.iLogApp.logisticApp.com.services.IService.IReceptionService;
import com.iLogApp.logisticApp.com.services.IService.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/receptions")
public class ReceptionController {
    @Autowired
    IReceptionService iReceptionService;

    @GetMapping("/getPage/{numberPage}")
    public Optional<Page<Reception>> getAllReceptions (@PathVariable int numberPage){
        return iReceptionService.getAll(numberPage);
    }

    @PostMapping
    public Optional<?> saveReception(@RequestBody Reception reception){
        return iReceptionService.save(reception);
    }
    @PostMapping("/controlReception")
    public Optional<?>controlReception(@RequestBody Reception reception){
        return iReceptionService.controlReception(reception);
    }
    @DeleteMapping("/{id}")
    public Optional<?> deleteReception(@PathVariable Long id){
        return iReceptionService.deleteById(id);
    }
    @GetMapping("/{id}")
    public Optional<Reception>getProductInStorageById(@PathVariable Long id){
        return iReceptionService.getById(id);
    }
}

