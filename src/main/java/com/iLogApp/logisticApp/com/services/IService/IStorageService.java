package com.iLogApp.logisticApp.com.services.IService;

import com.iLogApp.logisticApp.com.entities.Category;
import com.iLogApp.logisticApp.com.entities.Product;
import com.iLogApp.logisticApp.com.entities.Storage;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IStorageService {
    Optional<Page<Storage>> getAll(int numberPage);
    Optional<Storage>getById(Long id);
    Optional<?>deleteById(Long id);
    Optional<Storage> save(Storage storage);

}
