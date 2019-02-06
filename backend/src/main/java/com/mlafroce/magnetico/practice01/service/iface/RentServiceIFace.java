package com.mlafroce.magnetico.practice01.service.iface;

import com.mlafroce.magnetico.practice01.model.Apartment;
import com.mlafroce.magnetico.practice01.model.Rent;

/**
 * Interfaz de servicio de alquileres
 */
public interface RentServiceIFace {
	/**
	 * Almacena un alquiler efectuado
	 * 
	 * @param Alquiler a persistir
	 * @return Id generado
	 */
	Long save(Rent rent);

	/**
	 * Devuelve si ya el usuario había alquilado el departamento con anterioridad
	 * @param apartment
	 * @param username
	 * @return
	 */
	Boolean previousRentExists(Apartment apartment, String username);
	
	/**
	 * Devuelve el precio estimado de alquiler
	 * @param apartment
	 * @param username
	 * @return
	 */
	Double estimate(Apartment apartment, String username, Integer days, Integer months);
}
