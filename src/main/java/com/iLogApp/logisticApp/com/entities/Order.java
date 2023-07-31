package com.iLogApp.logisticApp.com.entities;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;


@Entity
@Table(name="orders")
@Data
public class Order {
	
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
