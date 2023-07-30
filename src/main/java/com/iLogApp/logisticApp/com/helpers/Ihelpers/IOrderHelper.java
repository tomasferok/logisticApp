package com.iLogApp.logisticApp.com.helpers.Ihelpers;

import com.iLogApp.logisticApp.com.entities.Order;

import java.util.Optional;

public interface IOrderHelper {
    Order setAmountProductInStorage(Order order);
    void orderValidations(Order order);

    Optional<?> packOffOrder(Order order);
}
