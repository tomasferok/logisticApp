package com.iLogApp.logisticApp.com.entities;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="receptions")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Reception{

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
