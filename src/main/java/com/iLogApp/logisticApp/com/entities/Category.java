package com.iLogApp.logisticApp.com.entities;



import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@Entity
@Table(name="categories")
@Data
public class Category {



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCat;

	private String nameCat;

}
