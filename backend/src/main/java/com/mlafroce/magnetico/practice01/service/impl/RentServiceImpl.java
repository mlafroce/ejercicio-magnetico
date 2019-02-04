package com.mlafroce.magnetico.practice01.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mlafroce.magnetico.practice01.dao.iface.RentDaoIFace;
import com.mlafroce.magnetico.practice01.model.Apartment;
import com.mlafroce.magnetico.practice01.model.Rent;
import com.mlafroce.magnetico.practice01.service.iface.RentServiceIFace;

@Service
@Transactional
public class RentServiceImpl implements RentServiceIFace {

	@Autowired
	private RentDaoIFace rentDao;

	@Override
	public Long save(Rent rent) {
		return rentDao.save(rent);
	}

	@Override
	public Boolean previousRentExists(Apartment apartment, String username) {
		return rentDao.previousRentExists(apartment, username);
	}

}
