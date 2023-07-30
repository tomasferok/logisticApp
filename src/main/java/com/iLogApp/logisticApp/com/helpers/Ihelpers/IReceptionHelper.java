package com.iLogApp.logisticApp.com.helpers.Ihelpers;

import com.iLogApp.logisticApp.com.entities.ProductInStorage;
import com.iLogApp.logisticApp.com.entities.Reception;

import java.util.Optional;

public interface IReceptionHelper {
    Optional<?>controlReception(Reception reception);
    Optional<?> saveReceptionProductsInStorage(Reception reception);

    ProductInStorage findProductInStorageInReception(Reception reception, ProductInStorage productInStorage);
}
