package org.sprouts.backend.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
@Access(AccessType.PROPERTY)
@Table
public class Car extends DomainEntity {

	// Attributes -------------------------------------------------------------

	private String brand;
	private String model;
	private String numberPlate;

	// Constructors -----------------------------------------------------------
	
	public Car() {

	}
	
	public Car(String brand, String model, String numberPlate) {
		super();
		this.brand = brand;
		this.model = model;
		this.numberPlate = numberPlate;
	}
	
	// Getters/Setters --------------------------------------------------------
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getNumberPlate() {
		return numberPlate;
	}

	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}
	
	// Relationships ----------------------------------------------------------
	
	public User user;

	@NotNull
	@Valid
	@ManyToOne(optional=false)
	@JoinColumn(name="userId")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}