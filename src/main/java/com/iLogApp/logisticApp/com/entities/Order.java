package com.iLogApp.logisticApp.com.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Entity
@Table(name="orders")
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idOrder")
public class Order implements Serializable{
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOrder;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="prods_id")
	private List<ProductInStorage> products;
	private double amount;

	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;

	private double total;
	
	private static final long serialVersionUID = 1L;


}
