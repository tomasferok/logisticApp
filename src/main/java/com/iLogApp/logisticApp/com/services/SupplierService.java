package com.iLogApp.logisticApp.com.services;

import com.iLogApp.logisticApp.com.entities.Supplier;
import com.iLogApp.logisticApp.com.repositories.JpaSupplierRepository;
import com.iLogApp.logisticApp.com.services.IService.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SupplierService implements ISupplierService {
    @Autowired
    JpaSupplierRepository jpaSupplierRepository;

    @Override
    public Optional<Page<Supplier>> getAll(int numberPage) {
        int pageSize= 10;
        PageRequest page= PageRequest.of(numberPage, pageSize);
        return Optional.of(jpaSupplierRepository.findAll(page));
    }

    @Override
    public Optional<Supplier> getById(Long id) {
        if (jpaSupplierRepository.existsById(id)){
           Optional<Supplier> supplierFinded= jpaSupplierRepository.findById(id);
           return supplierFinded;
        }
        return Optional.empty();
    }

    @Override
    public Optional<?> deleteById(Long id) {
        if (jpaSupplierRepository.existsById(id)){
            Optional<Supplier> supplierDeleted= jpaSupplierRepository.findById(id);
            jpaSupplierRepository.deleteById(id);
            String message = "The supplier: " + supplierDeleted.get().getNameSupplier() + " has been deleted";
            return Optional.of(message);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Supplier> save(Supplier supplier) {
        return Optional.of(jpaSupplierRepository.save(supplier));
    }
}
