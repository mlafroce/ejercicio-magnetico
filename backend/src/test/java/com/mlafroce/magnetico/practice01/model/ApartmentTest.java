package com.mlafroce.magnetico.practice01.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ApartmentTest {
	@Test
	/**
	 * Calcula el precio de un departamento sin alquiler previo ni descuento
	 */
	public void testNonRentedNonDiscount() {
		Apartment apartment = new Apartment("Gerli", 1, 20, 1000.0, 25000.0);
		assertEquals(1000.0, apartment.estimate(1, 0, false), 0.1);
		assertEquals(4000.0, apartment.estimate(4, 0, false), 0.1);
	}
	
	@Test
	/**
	 * Calcula el precio de un departamento sin alquiler previo pero con descuentos por dia
	 */
	public void testNonRentedWithDiscounts() {
		Apartment apartment = new Apartment("Gerli", 1, 20, 1000.0, 25000.0);
		assertEquals(9500.0, apartment.estimate(10, 0, false), 0.1);
		assertEquals(17000.0, apartment.estimate(20, 0, false), 0.1);
		// Alquiler 0 dias, 1 mes
		assertEquals(21250.0, apartment.estimate(0, 1, false), 0.1);
	}
	
	@Test
	/**
	 * Calcula el precio de un departamento con alquiler previo
	 */
	public void testRented() {
		Apartment apartment = new Apartment("Gerli", 1, 20, 1000.0, 25000.0);
		assertEquals(950.0, apartment.estimate(1, 0, true), 0.1);
		assertEquals(9000.0, apartment.estimate(10, 0, true), 0.1);
		assertEquals(16000.0, apartment.estimate(20, 0, true), 0.1);
		// Alquiler 0 dias, 1 mes
		assertEquals(20000.0, apartment.estimate(0, 1, true), 0.1);
	}
}
