package com.iLogApp.logisticApp.com.controllers;
import com.iLogApp.logisticApp.com.entities.Order;
import com.iLogApp.logisticApp.com.services.IService.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    IOrderService iOrderService;

    @GetMapping("/getPage/{numberPage}")
    public Optional<Page<Order>> getAllOrders (@PathVariable int numberPage){
        return iOrderService.getAll(numberPage);
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrderById(@PathVariable Long id){

        return iOrderService.getById(id);
    }
    @PostMapping
    public Optional<Order> saveOrder(@RequestBody Order order){
        return iOrderService.save(order);
    }
    @PostMapping("/packOff")
    public Optional<?> packOff(@RequestBody Order order){
        return iOrderService.packOff(order);
    }
    @DeleteMapping("/{id}")
    public Optional<?>deleteOrderById(@PathVariable Long id){
        return iOrderService.deleteById(id);
    }
}
