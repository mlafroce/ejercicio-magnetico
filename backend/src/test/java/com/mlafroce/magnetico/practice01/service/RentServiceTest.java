package com.mlafroce.magnetico.practice01.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.transaction.BeforeTransaction;

import com.mlafroce.magnetico.practice01.model.Apartment;
import com.mlafroce.magnetico.practice01.model.Rent;
import com.mlafroce.magnetico.practice01.service.iface.ApartmentServiceIFace;
import com.mlafroce.magnetico.practice01.service.iface.RentServiceIFace;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class RentServiceTest {
	@Autowired
	private ApartmentServiceIFace apartmentService;
	@Autowired 
	private RentServiceIFace rentService;
	
	Apartment testApartment;
	
	@BeforeTransaction
	public void setup() {
		testApartment = new Apartment("Gerli", 1, 20, 80.0, 3000.0);
		apartmentService.save(testApartment);
	}
	
	@Test
	/**
	 * Comprueba si al buscar un alquiler nunca realizado, devuelve que no existe
	 */
	public void getNotRented() {
		assertNotNull(rentService);
		Boolean exists = rentService.previousRentExists(testApartment, "notExists");
		assertFalse(exists);
	}
	
	@Test
	/**
	 * Comprueba si al buscar un alquiler ya realizado, devuelve que existe
	 */
	public void getRented() {
		assertNotNull(rentService);
		Rent rent = new Rent(testApartment, "exists");
		rentService.save(rent);
		Boolean exists = rentService.previousRentExists(testApartment, "exists");
		assertTrue(exists);
	}
}
