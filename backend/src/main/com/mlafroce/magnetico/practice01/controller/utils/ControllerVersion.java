package com.mlafroce.magnetico.practice01.controller.utils;

/**
 * Información breve sobre el controlador de la API expuesta 
 *
 */
public class ControllerVersion {
	private String shortDescription;
	private Double version;
	
	public ControllerVersion(Double version, String shortDescription) {
		this.shortDescription = shortDescription;
		this.version = version;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public Double getVersion() {
		return version;
	}
}
