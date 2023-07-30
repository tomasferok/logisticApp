package com.iLogApp.logisticApp.com.entities;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="receptions")
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "idRecep")
public class Reception implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRecep;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="supplier_id")
	private Supplier supplier;
	@OneToMany(mappedBy = "reception", fetch = FetchType.EAGER)
	private List<ProductInStorage> list_prods;
	private String state;
}
