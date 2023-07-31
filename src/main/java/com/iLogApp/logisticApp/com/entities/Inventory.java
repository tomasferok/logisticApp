package com.iLogApp.logisticApp.com.entities;

import jakarta.persistence.Entity;
import lombok.Data;

import java.util.Map;

@Entity(name="inventories")
@Data
public class Inventory {
    private Long idInventory;
    private String nameInventory;
    private Map<String,Double> buys;
    private Map<String,Double> sells;
}
