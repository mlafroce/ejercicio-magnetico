package com.mlafroce.magnetico.practice01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mlafroce.magnetico.practice01.controller.utils.ControllerVersion;

/**
 * API publica de departamentos, permite listar y alquilarlos
 * 
 */
@RestController
@RequestMapping("apartments")
public class ApartmentController {
	public static final String CONTROLLER_DESCRIPTION = "Departamentos";

	@GetMapping("/version")
    public ControllerVersion getVersion() {
        return new ControllerVersion(0.1, CONTROLLER_DESCRIPTION);
    }
}
