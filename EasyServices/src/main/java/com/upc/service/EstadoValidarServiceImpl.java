package com.upc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.entity.EstadoValidar;
import com.upc.repository.EstadoValidarRepository;

@Service
public class EstadoValidarServiceImpl implements EstadoValidarService{

	@Autowired
	private EstadoValidarRepository estadoValidarRepository;
	
	@Override
	public Iterable<EstadoValidar> listAllEstadoValidar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EstadoValidar getEstadoValidarById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EstadoValidar saveEstadoValidar(EstadoValidar estadoValidar) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEstadoValidar(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
