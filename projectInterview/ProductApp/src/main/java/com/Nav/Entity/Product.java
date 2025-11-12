package com.Nav.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.apache.commons.lang3.builder.ToStringExclude;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data

@Setter
@Getter
public class Product {

	@ToStringExclude
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	private String type;
	
	private String unit;
	
	 @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	    private List<Subproduct> subProducts = new ArrayList<>();
	
	
}
