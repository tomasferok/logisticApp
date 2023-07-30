package com.iLogApp.logisticApp.com.services.IService;

import com.iLogApp.logisticApp.com.entities.Order;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IOrderService {
    Optional<Page<Order>> getAll(int numberPage);
    Optional<Order>getById(Long id);
    Optional<?>deleteById(Long id);
    Optional<Order> save(Order order);
    Optional<?>packOff(Order order);
}
