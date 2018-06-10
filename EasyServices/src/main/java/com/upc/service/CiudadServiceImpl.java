package com.upc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.entity.Ciudad;
import com.upc.repository.CiudadRepository;

@Service
public class CiudadServiceImpl implements CiudadService{

	@Autowired
	private CiudadRepository ciudadRepository;
	
	@Override
	public Iterable<Ciudad> listAllCiudad() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ciudad getCiudadById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ciudad saveCiudad(Ciudad ciudad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCiudad(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
