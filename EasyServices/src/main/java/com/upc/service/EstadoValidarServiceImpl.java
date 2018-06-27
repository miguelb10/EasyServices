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
		return estadoValidarRepository.findAll();
	}

	@Override
	public EstadoValidar getEstadoValidarById(Integer id) {
		// TODO Auto-generated method stub
		return estadoValidarRepository.findOne(id);
	}

	@Override
	public EstadoValidar saveEstadoValidar(EstadoValidar estadoValidar) {
		// TODO Auto-generated method stub
		return estadoValidarRepository.save(estadoValidar);
	}

	@Override
	public void deleteEstadoValidar(Integer id) {
		// TODO Auto-generated method stub
		estadoValidarRepository.delete(id);
	}

}
