package com.upc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.entity.Empleado;
import com.upc.entity.Servicio;
import com.upc.repository.ServicioRepository;

@Service
public class ServicioServiceImpl implements ServicioService{

	@Autowired
	private ServicioRepository servicioRepository;
	
	@Override
	public Iterable<Servicio> listAllServicio() {
		// TODO Auto-generated method stub
		return servicioRepository.findAll();
	}

	@Override
	public Servicio getServicioById(Integer id) {
		// TODO Auto-generated method stub
		return servicioRepository.findOne(id);
	}

	@Override
	public Servicio saveServicio(Servicio servicio) {
		// TODO Auto-generated method stub
		return servicioRepository.save(servicio);
	}

	@Override
	public void deleteServicio(Integer id) {
		// TODO Auto-generated method stub
		servicioRepository.delete(id);
	}

	@Override
	public Iterable<Servicio> getServicioByEmpleado(Empleado empleado) {
		// TODO Auto-generated method stub
		return servicioRepository.findByEmpleado(empleado);
	}

}
