package com.iLogApp.logisticApp.com.helpers;

import com.iLogApp.logisticApp.com.entities.Order;
import com.iLogApp.logisticApp.com.entities.ProductInStorage;
import com.iLogApp.logisticApp.com.exceptions.InvalidOrderException;
import com.iLogApp.logisticApp.com.helpers.Ihelpers.IOrderHelper;
import com.iLogApp.logisticApp.com.repositories.JpaProductInStorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class OrderHelper implements IOrderHelper {
@Autowired
    JpaProductInStorageRepository jpaProductInStorageRepository;
    @Override
    public Order setAmountProductInStorage(Order order) {
      /*order.getProducts()
                .stream()
                .forEach(productInStorage -> {
                    productInStorage.setAmount(productInStorage.getAmount() - productInStorage
                            .getAmountInOrder());
                    jpaProductInStorageRepository.save(productInStorage);
                }
                );*/

    return order;
    }

    @Override
    public void orderValidations(Order order) {
        checkIfAmountIsMajorThanAmountOrder(order);
    }

    @Override
    public Optional<?> packOffOrder(Order order) {

        StringBuilder messageBuilder = new StringBuilder();

        order.getProducts()
                .forEach(product->{
                    ifIdIs0DeleteProduct(messageBuilder, product);
                });
        messageBuilder.append("The order ").append(order.getIdOrder()).append(" has been packed off");
        return Optional.of(messageBuilder.toString());
    }

    private void ifIdIs0DeleteProduct(StringBuilder messageBuilder, ProductInStorage product) {
        if(product.getAmount() != 0){
            product.setAmountInOrder(0);
            jpaProductInStorageRepository.save(product);

        }
        else{
            messageBuilder.append("The storage ").append(product.getStorage().getName())
                    .append(" does not have more stock of product ")
                    .append(product.getNameProduct()).append("\n");
            jpaProductInStorageRepository.deleteById(product.getIdProductInStorage());
        }
    }

    private void checkIfAmountIsMajorThanAmountOrder(Order order) {
        ProductInStorage productAmountInvalid = order.getProducts().
                stream()
                .filter(prod-> prod.getAmountInOrder()>prod.getAmount())
                .findFirst()
                .orElse(null);
        if (productAmountInvalid != null){
            throw new InvalidOrderException
                    ("The amount ordered can´t be major than the amount in storage on product: " +productAmountInvalid.getNameProduct());
        }
    }
}
