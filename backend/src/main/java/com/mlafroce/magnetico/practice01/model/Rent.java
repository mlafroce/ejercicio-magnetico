package com.mlafroce.magnetico.practice01.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Alquiler efectuado por un cliente Se podrían agregar más datos, como el
 * cliente, fecha de alquiler, pago, etc
 */
@Entity
public class Rent {
	/**
	 * Id del alquiler No es necesario pero me facilita algunas cosas
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/**
	 * Departamento alquilado
	 */
	@ManyToOne
	private Apartment apartment;
	/**
	 * Usuario que lo alquila
	 */
	private String username;

	public Rent() {}
	
	public Rent(Apartment apartment, String username) {
		this.apartment = apartment;
		this.username = username;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Apartment getApartment() {
		return apartment;
	}

	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
