package com.upc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.entity.Empleado;
import com.upc.entity.Usuario;
import com.upc.repository.EmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{

	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@Override
	public Iterable<Empleado> listAllEmpleado() {
		// TODO Auto-generated method stub
		return empleadoRepository.findAll();
	}

	@Override
	public Empleado getEmpleadoById(Integer id) {
		// TODO Auto-generated method stub
		return empleadoRepository.findOne(id);
	}

	@Override
	public Empleado saveEmpleado(Empleado empleado) {
		// TODO Auto-generated method stub
		return empleadoRepository.save(empleado);
	}

	@Override
	public void deleteEmpleado(Integer id) {
		// TODO Auto-generated method stub
		empleadoRepository.delete(id);
	}

	@Override
	public Iterable<Empleado> getEmpresaByUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return empleadoRepository.findByUsuario(usuario);
	}

}
