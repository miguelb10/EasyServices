package com.upc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.entity.Especialidad;
import com.upc.repository.EspecialidadRepository;

@Service
public class EspecialidadServiceImpl implements EspecialidadService{

	@Autowired
	private EspecialidadRepository especialidadRepository;
	
	@Override
	public Iterable<Especialidad> listAllEspecialidad() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Especialidad getEspecialidadById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Especialidad saveEspecialidad(Especialidad especialidad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEspecialidad(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
