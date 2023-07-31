package com.iLogApp.logisticApp.com.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name="products_sold")
@Data

public class ProductSold {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProductSold;
    private String nameProduct;
    @Column(name = "barcode")
    private String barcode;
    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "description")
    private String description;

    @Column(name = "amount", nullable = false)
    private double amount;
}
