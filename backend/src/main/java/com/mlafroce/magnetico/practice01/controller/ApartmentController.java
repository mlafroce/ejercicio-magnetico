package com.mlafroce.magnetico.practice01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	/**
	 * Lista todos los departamentos en la base de datos
	 */
	@GetMapping("/")
    public List<Apartment> list() {
        return apartmentService.list();
    }
	
	/**
	 * Devuelve el costo estimado de alquilar el departamento con id {id} durante {days} dias
	 * @param days: dias de alquiler
	 * @return costo estimado del alquiler
	 */
	@GetMapping("/{id}/estimate")
    public Double estimate(@PathVariable("id") String id, @RequestParam("days") String days) {
		Long longId = Long.decode(id);
		Integer intDays = Integer.decode(days);
		Apartment apartment = apartmentService.getById(longId);
		Double cost = apartment.estimate(intDays);
        return cost;
    }
	
	@GetMapping("/version")
    public ControllerVersion getVersion() {
        return new ControllerVersion(0.1, CONTROLLER_DESCRIPTION);
    }
}
