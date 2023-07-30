package com.iLogApp.logisticApp.com.helpers;

import com.iLogApp.logisticApp.com.entities.ProductInStorage;
import com.iLogApp.logisticApp.com.entities.Reception;
import com.iLogApp.logisticApp.com.enums.State;
import com.iLogApp.logisticApp.com.helpers.Ihelpers.IReceptionHelper;
import com.iLogApp.logisticApp.com.repositories.JpaProductInStorageRepository;
import com.iLogApp.logisticApp.com.repositories.JpaReceptionRepository;
import com.iLogApp.logisticApp.com.services.IService.IProductInStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Component
public class ReceptionHelper implements IReceptionHelper {
    @Autowired
    JpaReceptionRepository jpaReceptionRepository;
    @Autowired
    IProductInStorageService iProductInStorageService;
    @Autowired
    JpaProductInStorageRepository jpaProductInStorageRepository;
    @Override
    public Optional<?> controlReception(Reception expectedReception) {
        AtomicReference<String> message = new AtomicReference<>();
        AtomicBoolean productsWithDifference = new AtomicBoolean();
        productsWithDifference.set(false);
        Optional<Reception> recibedReception = jpaReceptionRepository.findById(expectedReception.getIdRecep());
        recibedReception.get()
                .getList_prods().stream()
                .forEach(prodRecibed ->{
                    ProductInStorage productExpected = findProductInStorageInReception(expectedReception,
                            prodRecibed);
                    if(prodRecibed.getAmount() != productExpected.getAmount()){
                        productsWithDifference.set(true);
                        message.set("The product: " + prodRecibed.getNameProduct()
                        + " amount is different to the expected");
                    }else{
                        message.set("The product: " + prodRecibed.getNameProduct()
                                + " has been controlled correctly");
                        prodRecibed.setState(State.CONTROLLED);
                        jpaProductInStorageRepository.save(prodRecibed);
                    }
                });
        return Optional.of(message);
    }

    @Override
    public synchronized Optional<List<Optional<?>>> saveReceptionProductsInStorage(Reception reception) {
        List<ProductInStorage> productsInReception = reception.getList_prods();
        reception.setList_prods(null);
        Reception savedReception = jpaReceptionRepository.save(reception);

        List<Optional<?>> savedProducts = productsInReception.stream()
                .peek(prod -> prod.setReception(savedReception))
                .map(iProductInStorageService::save)
                .collect(Collectors.toList());

        return Optional.of(savedProducts);
    }

    @Override
    public ProductInStorage findProductInStorageInReception(Reception reception, ProductInStorage productInStorage) {
        return reception.getList_prods()
                .stream()
                .filter(prod -> prod.getIdProductInStorage().equals(productInStorage.getIdProductInStorage()))
                .findFirst()
                .orElse(null);
    }
}
