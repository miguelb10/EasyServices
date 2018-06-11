package com.upc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.entity.Administrador;
import com.upc.entity.Usuario;
import com.upc.repository.AdministradorRepository;

@Service
public class AdministradorServiceImpl implements AdministradorService{

	@Autowired
	private AdministradorRepository administradorRepository;
	
	@Override
	public Iterable<Administrador> listAllAdministrador() {
		// TODO Auto-generated method stub
		return administradorRepository.findAll();
	}

	@Override
	public Administrador getAdministradorById(Integer id) {
		// TODO Auto-generated method stub
		return administradorRepository.findOne(id);
	}

	@Override
	public Administrador saveAdministrador(Administrador administrador) {
		// TODO Auto-generated method stub
		return administradorRepository.save(administrador);
	}

	@Override
	public void deleteAdministrador(Integer id) {
		// TODO Auto-generated method stub
		administradorRepository.delete(id);
	}

	@Override
	public Iterable<Administrador> getEmpresaByUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return administradorRepository.findByUsuario(usuario);
	}

}
