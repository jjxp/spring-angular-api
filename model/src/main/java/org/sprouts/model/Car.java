package org.sprouts.model;

import javax.persistence.*;
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

	private User user;

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