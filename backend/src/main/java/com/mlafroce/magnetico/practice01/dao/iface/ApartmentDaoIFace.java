package com.mlafroce.magnetico.practice01.dao.iface;

import java.util.List;

import com.mlafroce.magnetico.practice01.model.Apartment;

/**
 * Interfaz de persistencia de departamentos
 */
public interface ApartmentDaoIFace {
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

	/**
	 * Modifica un departamento
	 * @param departamento a modificar. Debe poseer un id válido
	 */
	void update(Apartment apartment);

	/**
	 * Elimina un departamento
	 * @param id del departamento a eliminar
	 */
	void delete(Long id);
}
