package com.iLogApp.logisticApp.com.helpers;
import com.iLogApp.logisticApp.com.entities.ProductInStorage;
import com.iLogApp.logisticApp.com.enums.State;
import com.iLogApp.logisticApp.com.exceptions.InvalidProductCategoryException;
import com.iLogApp.logisticApp.com.helpers.Ihelpers.IProductInStorageHelper;
import com.iLogApp.logisticApp.com.repositories.JpaProductInStorageRepository;
import com.iLogApp.logisticApp.com.services.IService.IProductInStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductInStorageHelper implements IProductInStorageHelper {
    @Autowired
    JpaProductInStorageRepository jpaProductInStorageRepository;

    @Override
    public Optional<?> IfProductNameExistIncreaseAmount(ProductInStorage product) {
        ProductInStorage productInStorage = jpaProductInStorageRepository.
                findByNameProductAndStorage(product.getNameProduct(), product.getStorage());
        if(productInStorage != null && product.getPurchasePrice() != productInStorage.getPurchasePrice()){
            productInStorage.setAmount(productInStorage.getAmount() + product.getAmount());
            jpaProductInStorageRepository.save(productInStorage);
            String message= "The product "+ product.getNameProduct() +
                    " has been increase the amount in " + product.getAmount();
            return Optional.of(message);
        }
        return Optional.empty();
    }

    @Override
    public void checkProductInStorageState(ProductInStorage product) {
        if(product.getState().describeConstable().isEmpty()){
            product.setState(State.PENDING);
        }
    }

    @Override
    public void productInStorageValidations(ProductInStorage product) {
        try {
            checkTheIfTheProductCategoryIsDifferentToStorageCategory(product);
        } catch (InvalidProductCategoryException ex) {

            throw new RuntimeException(ex.getMessage());
        }
    }

    private void checkTheIfTheProductCategoryIsDifferentToStorageCategory(ProductInStorage product) {
        if (!product.getCategory().getIdCat().equals(product.getStorage().getCategory().getIdCat())) {
            throw new InvalidProductCategoryException("The product category hasn't been different from the storage category");
        }
    }


}
