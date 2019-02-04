package com.mlafroce.magnetico.practice01.dao.iface;

import com.mlafroce.magnetico.practice01.model.Apartment;
import com.mlafroce.magnetico.practice01.model.Rent;

/**
 * Interfaz de persistencia de alquileres
 */
public interface RentDaoIFace {
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
}
