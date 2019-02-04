package com.mlafroce.magnetico.practice01.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mlafroce.magnetico.practice01.model.Apartment;
import com.mlafroce.magnetico.practice01.service.iface.ApartmentServiceIFace;

/**
 * Test del servicio de departamentos
 * Se utiliza \@Transactional para lograr independencia entre tests
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class ApartmentServiceTest {
	@Autowired
	private ApartmentServiceIFace apartmentService;
	
	@Test
	public void getEmptyApartments() {
		assertNotNull(apartmentService);
		List<Apartment> apartments = apartmentService.list();
		assertTrue(apartments.isEmpty());
	}
	
	@Test
	public void getOneApartment() {
		assertNotNull(apartmentService);
		Apartment apartment = new Apartment("Gerli", 1, 20, 80.0, 3000.0);
		apartmentService.save(apartment);
		List<Apartment> apartments = apartmentService.list();
		assertTrue(apartments.size() == 1);
		Apartment result = apartments.get(0);
		assertEquals("Gerli", result.getLocation());
		assertEquals(new Integer(1), result.getRooms());
		assertEquals(new Integer(20), result.getArea());
		assertEquals(new Double(80), result.getRentPerDay());
		assertEquals(new Double(3000), result.getRentPerMonth());
	}
}
