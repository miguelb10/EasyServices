package com.upc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.entity.Pais;
import com.upc.repository.PaisRepository;

@Service
public class PaisServiceImpl implements PaisService{

	@Autowired
	private PaisRepository paisRepository;
	
	@Override
	public Iterable<Pais> listAllPais() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pais getPaisById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pais savePais(Pais pais) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePais(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
