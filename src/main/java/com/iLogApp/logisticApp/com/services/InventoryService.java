package com.iLogApp.logisticApp.com.services;

import com.iLogApp.logisticApp.com.entities.Inventory;
import com.iLogApp.logisticApp.com.repositories.JpaInventoryRepository;
import com.iLogApp.logisticApp.com.services.IService.IInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventoryService  implements IInventoryService {

    @Autowired
    JpaInventoryRepository jpaInventoryRepository;

    @Override
    public Optional<Inventory> save(Inventory inventory) {
        return Optional.empty();
    }
}
