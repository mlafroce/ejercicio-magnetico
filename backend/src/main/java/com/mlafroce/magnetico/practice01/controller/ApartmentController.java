package com.mlafroce.magnetico.practice01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mlafroce.magnetico.practice01.controller.utils.ControllerVersion;
import com.mlafroce.magnetico.practice01.model.Apartment;
import com.mlafroce.magnetico.practice01.service.iface.ApartmentServiceIFace;

/**
 * API publica de departamentos, permite listar y alquilarlos
 * 
 */
@RestController
@RequestMapping("apartments")
public class ApartmentController {
	public static final String CONTROLLER_DESCRIPTION = "Departamentos";

	@Autowired
	ApartmentServiceIFace apartmentService;
	
	@GetMapping("/")
    public List<Apartment> list() {
        return apartmentService.list();
    }
	
	@GetMapping("/version")
    public ControllerVersion getVersion() {
        return new ControllerVersion(0.1, CONTROLLER_DESCRIPTION);
    }
}
