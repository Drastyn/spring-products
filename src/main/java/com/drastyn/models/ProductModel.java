package com.drastyn.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import com.drastyn.annotation.UniqueName;
import com.drastyn.annotation.UniqueBarcode;

@Entity
@Table(name = "products", indexes = {@Index(columnList = "barcode", unique = true), @Index(columnList = "name", unique = true)})
public class ProductModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private long id;

	@NotNull(message = "Name can't not be blank")
	@Column(unique = true, nullable = false)
	//@Pattern(regexp = "^[a-zA-Z\s]+", message = "Name must have only letters")
	@Size(min = 2, message = "Name should have atleast 2 characters")
	@UniqueName()
	private String name;
	private String description;
	@NotNull(message = "Price can't not be blank")
	private int price;
	@Column(unique = true, nullable = false)
	@UniqueBarcode()
	private String barcode;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
}
