package com.mlafroce.magnetico.practice01.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.mlafroce.magnetico.practice01.dao.iface.RentDaoIFace;
import com.mlafroce.magnetico.practice01.model.Apartment;
import com.mlafroce.magnetico.practice01.model.Rent;

@Repository
public class RentDaoImpl implements RentDaoIFace {
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Long save(Rent rent) {
		entityManager.persist(rent);
		return rent.getId();
	}

	@Override
	public Boolean previousRentExists(Apartment apartment, String username) {
		Query query = entityManager
				.createQuery(
						"select count(r)>0 from Rent r where r.apartment.id = :apartmentId and r.username = :username")
				.setParameter("apartmentId", apartment.getId())
				.setParameter("username", username);
		return (Boolean) query.getSingleResult();
	}

}
