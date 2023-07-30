package com.iLogApp.logisticApp.com.entities;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.iLogApp.logisticApp.com.enums.State;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;
import java.io.Serializable;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idProductInStorage")
public class ProductInStorage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProductInStorage;
    private String nameProduct;
    @Column(name = "barcode")
    private String barcode;
    @Column(name = "price", nullable = false)
    private double purchasePrice;
    private double salePrice;
    @ManyToOne
    private Category category;
    @Column(name = "description")
    private String description;
    @Enumerated(EnumType.STRING)
    private State state;
    @Column(name = "amount", nullable = false)
    @Min(value = 1, message = "the amount hasn´t bee less than 1")
    private int amount;
    @ManyToOne
    @JoinColumn(name = "storage_id")
    private Storage storage;

    @ManyToOne
    @JoinColumn(name = "reception_id")
    private Reception reception;
    private int amountInOrder;

}

