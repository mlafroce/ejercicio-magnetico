package com.mlafroce.magnetico.practice01.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mlafroce.magnetico.practice01.dao.iface.ApartmentDaoIFace;
import com.mlafroce.magnetico.practice01.model.Apartment;
import com.mlafroce.magnetico.practice01.service.iface.ApartmentServiceIFace;

@Service
@Transactional
public class ApartmentServiceImpl implements ApartmentServiceIFace {

	@Autowired
	private ApartmentDaoIFace apartmentDao;

	@Override public Long save(Apartment apartment) {
		return apartmentDao.save(apartment);
	}

	@Override
	public Apartment getById(Long id) {
		return apartmentDao.getById(id);
	}

	@Override
	public List<Apartment> list() {
		return apartmentDao.list();
	}

}
