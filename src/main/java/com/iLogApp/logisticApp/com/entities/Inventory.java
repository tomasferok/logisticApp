package com.iLogApp.logisticApp.com.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Entity(name="inventories")
@Data
@NoArgsConstructor
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInventory;
    private String nameInventory;
    private Map<String,Double> buys;
    private Map<String,Double> sells;

    public Inventory(Map<String, Double> buys, Map<String, Double> sells) {
        this.buys = buys;
        this.sells = sells;
    }
}
