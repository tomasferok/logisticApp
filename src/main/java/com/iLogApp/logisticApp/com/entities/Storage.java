package com.iLogApp.logisticApp.com.entities;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;


@Entity
@Table(name ="storages")
@Getter @Setter
@ToString
@EqualsAndHashCode
public class Storage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idStorage;
	private String name;
	@ManyToOne
	private Category category;
	@OneToMany(mappedBy = "storage")
	private List<ProductInStorage> prods;
	private static final long serialVersionUID = 1L;
	


	
	

}
