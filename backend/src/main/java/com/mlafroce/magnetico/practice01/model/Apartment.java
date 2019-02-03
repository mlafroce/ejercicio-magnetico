package com.mlafroce.magnetico.practice01.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Representa un departamento Siendo un modelo tan chico y de juguete, no veo la
 * necesidad de tener un proxy para comunicarse con la BD por separado
 *
 */
@Entity
public class Apartment {
	/**
	 * Id del departamento
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/**
	 * Ubicación
	 */
	private String location;
	/**
	 * Cantidad de habitaciones
	 */
	private Integer rooms;
	/**
	 * Area en metros cuadrados
	 */
	private Integer area;
	/**
	 * Alquiler por día
	 */
	private Double rentPerDay;
	/**
	 * Alquiler por mes
	 */
	private Double rentPerMonth;

	public Apartment() {
	}

	public Apartment(String location, Integer rooms, Integer area, Double rentPerDay, Double rentPerMonth) {
		this.location = location;
		this.rooms = rooms;
		this.area = area;
		this.rentPerDay = rentPerDay;
		this.rentPerMonth = rentPerMonth;
	}

	public Long getId() {
		return this.id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getRooms() {
		return rooms;
	}

	public void setRooms(Integer rooms) {
		this.rooms = rooms;
	}

	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

	public Double getRentPerDay() {
		return rentPerDay;
	}

	public void setRentPerDay(Double rentPerDay) {
		this.rentPerDay = rentPerDay;
	}

	public Double getRentPerMonth() {
		return rentPerMonth;
	}

	public void setRentPerMonth(Double rentPerMonth) {
		this.rentPerMonth = rentPerMonth;
	}
}
