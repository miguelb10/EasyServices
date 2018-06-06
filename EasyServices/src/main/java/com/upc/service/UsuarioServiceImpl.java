package com.upc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.entity.Usuario;
import com.upc.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public Iterable<Usuario> listAllUsuario() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario getUsuarioById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario saveUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUsuario(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario findByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return usuarioRepository.findByUsernameAndPassword(username, password);
	}


}
