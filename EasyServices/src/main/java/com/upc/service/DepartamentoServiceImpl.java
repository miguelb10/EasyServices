package com.upc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.entity.Departamento;
import com.upc.repository.DepartamentoRepository;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	@Override
	public Iterable<Departamento> listAllDepartamento() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Departamento getDepartamentoById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Departamento saveDepartamento(Departamento departamento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteDepartamento(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
