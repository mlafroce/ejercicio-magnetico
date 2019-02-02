package com.mlafroce.magnetico.practice01.controller.utils;

/**
 * Información breve sobre el controlador de la API expuesta
 *
 */
public class ControllerVersion {
	private String shortDescription;
	private Double version;

	public ControllerVersion() {
	}

	public ControllerVersion(Double version, String shortDescription) {
		this.shortDescription = shortDescription;
		this.version = version;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public Double getVersion() {
		return version;
	}

	public void setVersion(Double version) {
		this.version = version;
	}
}
