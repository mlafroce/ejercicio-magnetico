package com.mlafroce.magnetico.practice01.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.mlafroce.magnetico.practice01.controller.utils.ControllerVersion;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApartmentControllerTest {
	
    @LocalServerPort
    private int port;
    
	@Autowired
	private ApartmentController controller;
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void contexLoads() throws Exception {
		assertNotNull(controller);
	}

    @Test
    public void getControllerVersion() throws Exception {
        assertEquals(ApartmentController.CONTROLLER_DESCRIPTION,
        		this.restTemplate.getForObject("http://localhost:" + port + "/apartments/version",
        		ControllerVersion.class).getShortDescription());
    }
}