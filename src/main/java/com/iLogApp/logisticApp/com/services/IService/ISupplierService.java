package com.iLogApp.logisticApp.com.services.IService;
import com.iLogApp.logisticApp.com.entities.Supplier;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ISupplierService {
    Optional<Page<Supplier>> getAll(int numberPage);
    Optional<Supplier>getById(Long id);
    Optional<?>deleteById(Long id);
    Optional<Supplier> save(Supplier supplier);
}
