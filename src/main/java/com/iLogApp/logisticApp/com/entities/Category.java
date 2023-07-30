package com.iLogApp.logisticApp.com.entities;



import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@Entity
@Table(name="categories")
@Data
public class Category implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCat;

	private String nameCat;

}
