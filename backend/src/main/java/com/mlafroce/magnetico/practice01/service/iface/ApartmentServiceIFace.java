package com.mlafroce.magnetico.practice01.service.iface;

import java.util.List;

import com.mlafroce.magnetico.practice01.model.Apartment;

/**
 * Interfaz de servicio de departamentos
 */
public interface ApartmentServiceIFace {
	/**
	 * Almacena un departamento
	 * 
	 * @param Departamento a persistir
	 * @return Id generado
	 */
	Long save(Apartment apartment);

	/**
	 * Busca un departamento según su id. 
	 * @param id del departamento
	 * @return departamento
	 */
	Apartment getById(Long id);

	/**
	 * Trae todos los departamentos almacenados
	 * @return todos los departamentos de la base de datos
	 */
	List<Apartment> list();
}
