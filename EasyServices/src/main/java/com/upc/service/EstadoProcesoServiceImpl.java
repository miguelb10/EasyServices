package com.upc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.entity.EstadoProceso;
import com.upc.repository.EstadoProcesoRepository;

@Service
public class EstadoProcesoServiceImpl implements EstadoProcesoService {

	@Autowired
	private EstadoProcesoRepository estadoProcesoRepository;
	
	@Override
	public Iterable<EstadoProceso> listAllEstadoProceso() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EstadoProceso getEstadoProcesoById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EstadoProceso saveEstadoProceso(EstadoProceso estadoProceso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEstadoProceso(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
