package com.iLogApp.logisticApp.com.services;

import com.iLogApp.logisticApp.com.entities.Storage;
import com.iLogApp.logisticApp.com.repositories.JpaStorageRepository;
import com.iLogApp.logisticApp.com.services.IService.IStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StorageService implements IStorageService{
    @Autowired
    JpaStorageRepository jpaStorageRepository;
    @Override
    public Optional<Page<Storage>> getAll(int numberPage) {
        int pageSize= 10;
        PageRequest page= PageRequest.of(numberPage, pageSize);
        return Optional.of(jpaStorageRepository.findAll(page));
    }

    @Override
    public Optional<Storage> getById(Long id) {
        if(jpaStorageRepository.existsById(id)){
            Optional<Storage> storageFinded = jpaStorageRepository.findById(id);
            return storageFinded;
        }
        return Optional.empty();
    }

    @Override
    public Optional<?> deleteById(Long id) {
        if(jpaStorageRepository.existsById(id)){
            Optional<Storage> storageDeleted = jpaStorageRepository.findById(id);
            jpaStorageRepository.deleteById(id);
            String message = "The storage: " + storageDeleted.get().getName() + " has been deleted";
            return Optional.of(message);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Storage> save(Storage storage) {
        return Optional.of(jpaStorageRepository.save(storage));
    }




}
