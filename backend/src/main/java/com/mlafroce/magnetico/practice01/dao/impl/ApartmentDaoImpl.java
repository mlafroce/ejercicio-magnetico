package com.mlafroce.magnetico.practice01.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.mlafroce.magnetico.practice01.dao.iface.ApartmentDaoIFace;
import com.mlafroce.magnetico.practice01.model.Apartment;

@Repository
public class ApartmentDaoImpl implements ApartmentDaoIFace {
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Long save(Apartment apartment) {
		entityManager.persist(apartment);
		return apartment.getId();
	}

	@Override
	public Apartment getById(Long id) {
		return entityManager.find(Apartment.class, id);
	}

	@Override
	public List<Apartment> list() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Apartment> cq = cb.createQuery(Apartment.class);
		Root<Apartment> root = cq.from(Apartment.class);
		cq.select(root);
		Query query = entityManager.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void update(Apartment apartment) {
		// TODO Fuera del scope del ejercicio
	}

	@Override
	public void delete(Long id) {
		// TODO Fuera del scope del ejercicio
	}

}
