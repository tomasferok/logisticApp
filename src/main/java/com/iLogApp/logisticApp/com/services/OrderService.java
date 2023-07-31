package com.iLogApp.logisticApp.com.services;

import com.iLogApp.logisticApp.com.entities.Order;
import com.iLogApp.logisticApp.com.helpers.Ihelpers.IOrderHelper;
import com.iLogApp.logisticApp.com.repositories.JpaOrderRepository;
import com.iLogApp.logisticApp.com.services.IService.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService implements IOrderService {
    @Autowired
    JpaOrderRepository jpaOrderRepository;
    @Autowired
    IOrderHelper iOrderHelper;

    @Override
    public Optional<Page<Order>> getAll(int numberPage) {
        int pageSize = 10;
        PageRequest page= PageRequest.of(numberPage, pageSize);
        return Optional.of(jpaOrderRepository.findAll(page));
    }

    @Override
    public Optional<Order> getById(Long id) {
        if(jpaOrderRepository.existsById(id)){
            Optional<Order> orderFinded = jpaOrderRepository.findById(id);
            return orderFinded;
        }
        return Optional.empty();
    }

    @Override
    public Optional<?> deleteById(Long id) {
        if(jpaOrderRepository.existsById(id)){
            Optional<Order> orderDeleted = jpaOrderRepository.findById(id);
            jpaOrderRepository.deleteById(id);
            return orderDeleted;
        }
        return Optional.empty();
    }

    @Override
    public Optional<Order> save(Order order) {
        Order orderToSave = iOrderHelper.setAmountProductInStorage(order);
        return Optional.of(jpaOrderRepository.save(orderToSave));
    }

    @Override
    public Optional<?> packOff(Order order) {
        return iOrderHelper.packOffOrder(order);
    }

}
