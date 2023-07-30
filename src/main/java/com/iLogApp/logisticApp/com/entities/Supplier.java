package com.iLogApp.logisticApp.com.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;


@Entity
@Table(name="suppliers")
@Data
public class Supplier implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProv;
	
	@Column(name="document", unique=true)
	private int document;
	
	@Column(nullable = false, length = 32)
	private String nameSupplier;

	@Column(nullable = false)
	private String contact;

	@Column(nullable = false, length = 32)
	private String mail;

	
}
