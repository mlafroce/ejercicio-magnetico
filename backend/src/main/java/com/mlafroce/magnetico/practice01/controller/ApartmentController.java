package com.mlafroce.magnetico.practice01.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mlafroce.magnetico.practice01.controller.utils.ControllerVersion;
import com.mlafroce.magnetico.practice01.model.Apartment;
import com.mlafroce.magnetico.practice01.model.Rent;
import com.mlafroce.magnetico.practice01.service.iface.ApartmentServiceIFace;
import com.mlafroce.magnetico.practice01.service.iface.RentServiceIFace;

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

	@Autowired
	RentServiceIFace rentService;

	/**
	 * Lista todos los departamentos en la base de datos
	 */
	@GetMapping("/")
	public List<Apartment> list() {
		return apartmentService.list();
	}

	/**
	 * Devuelve el costo estimado de alquilar el departamento con id {id} durante
	 * {days} dias y {month} meses
	 * 
	 * @param id: id del departamento a alquilar
	 * @param username: usuario que alquilar
	 * @param days: dias de alquiler
	 * @param months: meses de alquiler
	 * @return costo estimado del alquiler
	 * 
	 * @TODO: excepciones y otras cosas al
	 *         decodificar
	 */
	@GetMapping("/{id}/estimate")
	public Double estimate(@PathVariable("id") String id,
			@RequestParam("username") String username,
			@RequestParam("days") String days,
			@RequestParam("months") String months) {
		Long longId = Long.decode(id);
		Integer intDays = Integer.decode(days);
		Integer intMonths = Integer.decode(months);
		Apartment apartment = apartmentService.getById(longId);
		return rentService.estimate(apartment, username, intDays, intMonths);
	}
	
	/**
	 * Devuelve el costo estimado de alquilar el departamento con id {id} durante
	 * {days} dias
	 * 
	 * @param id: id del departamento a alquilar
	 * @param username: usuario que alquilar
	 * @return id del alquiler realizado
	 * 
	 * @TODO: excepciones y otras cosas al
	 *         decodificar
	 */
	@PostMapping("/{id}/rent")
	public Long estimate(@PathVariable("id") String id,
			@RequestBody Map<String, String> body) {
		Long longId = Long.decode(id);
		String username = body.get("username");
		Apartment apartment = apartmentService.getById(longId);
		Rent rent = new Rent(apartment, username);
		return rentService.save(rent);
	}

	@GetMapping("/version")
	public ControllerVersion getVersion() {
		return new ControllerVersion(0.1, CONTROLLER_DESCRIPTION);
	}
}
