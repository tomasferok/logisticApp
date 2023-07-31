package com.iLogApp.logisticApp.com.entities;

import jakarta.persistence.*;
import lombok.Data;


@Entity(name="products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;
    private String nameProduct;
    @Column(name = "barcode")
    private String barcode;
    @ManyToOne
    private Category category;
}
