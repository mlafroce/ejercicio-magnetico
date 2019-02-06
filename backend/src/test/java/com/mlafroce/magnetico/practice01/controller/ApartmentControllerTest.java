package com.mlafroce.magnetico.practice01.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.mlafroce.magnetico.practice01.controller.utils.ControllerVersion;
import com.mlafroce.magnetico.practice01.model.Apartment;
import com.mlafroce.magnetico.practice01.service.iface.ApartmentServiceIFace;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApartmentControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	private ApartmentController controller;

	@Autowired
	private ApartmentServiceIFace apartmentService;

	@Autowired
	private TestRestTemplate restTemplate;

	private Long apartment1id;
	private Long apartment2id;

	@Before
	public void setup() {
		Apartment apartment1 = new Apartment("Gerli", 1, 20, 100.0, 1000.0);
		Apartment apartment2 = new Apartment("Glew", 1, 20, 100.0, 1000.0);
		apartment1id = apartmentService.save(apartment1);
		apartment2id = apartmentService.save(apartment2);
	}

	@Test
	public void contextLoads() throws Exception {
		assertNotNull(controller);
	}

	@Test
	public void estimateNonRentedNoDiscounts() {
		String apiUrl = "http://localhost:" + port + "/apartments/"+ apartment1id +
				"/estimate?username=test&days=2&months=0";
		assertEquals(new Double(200.0),
		this.restTemplate.getForObject(apiUrl, Double.class));
	}
	
	@Test
	public void estimateNonRentedDiscounts() {
		String apiUrl = "http://localhost:" + port + "/apartments/"+ apartment1id +
				"/estimate?username=test&days=10&months=0";
		assertEquals(new Double(950.0),
		this.restTemplate.getForObject(apiUrl, Double.class));
		apiUrl = "http://localhost:" + port + "/apartments/"+ apartment1id +
				"/estimate?username=test&days=20&months=0";
		assertEquals(new Double(1700.0),
		this.restTemplate.getForObject(apiUrl, Double.class));
	}

	@Test
	public void estimateRentedNoDiscounts() {
		String apiUrl = "http://localhost:" + port + "/apartments/"+ apartment1id +
				"/estimate?username=test&days=2&months=0";
		String rentUrl = "http://localhost:" + port + "/apartments/"+ apartment1id +
				"/rent";
		
		assertEquals(new Double(200.0),
		  this.restTemplate.getForObject(apiUrl, Double.class));
		
		Map<String, String> params = new HashMap<>();
		params.put("username", "test");
		this.restTemplate.postForObject(rentUrl, params, String.class);
		
		assertEquals(new Double(190.0),
		  this.restTemplate.getForObject(apiUrl, Double.class));
	}
	
	@Test
	public void getControllerVersion() throws Exception {
		String apiUrl = "http://localhost:" + port + "/apartments/version";
		assertEquals(ApartmentController.CONTROLLER_DESCRIPTION,
				this.restTemplate.getForObject(apiUrl, ControllerVersion.class).getShortDescription());
	}
}