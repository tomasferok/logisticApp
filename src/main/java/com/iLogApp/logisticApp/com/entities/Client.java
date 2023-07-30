package com.iLogApp.logisticApp.com.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity(name="clients")
@Data
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;

    @Column(name="document", unique=true)
    private int document;

    @Column(nullable = false, length = 32)
    private String nameClient;

    @Column(nullable = false)
    private String contact;

    @Column(nullable = false, length = 32)
    private String mail;
}
