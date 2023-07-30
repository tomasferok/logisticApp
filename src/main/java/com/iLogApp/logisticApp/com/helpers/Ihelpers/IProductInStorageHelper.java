package com.iLogApp.logisticApp.com.helpers.Ihelpers;


import com.iLogApp.logisticApp.com.entities.Product;
import com.iLogApp.logisticApp.com.entities.ProductInStorage;

import java.util.Optional;

public interface IProductInStorageHelper {
    Optional<?>IfProductNameExistIncreaseAmount(ProductInStorage product);

    void checkProductInStorageState(ProductInStorage product);

    void productInStorageValidations(ProductInStorage product);

}
