package com.iLogApp.logisticApp.com.services.IService;

import com.iLogApp.logisticApp.com.entities.Inventory;

import java.util.Optional;

public interface IInventoryService {
    Optional<Inventory> save(Inventory inventory);
}
