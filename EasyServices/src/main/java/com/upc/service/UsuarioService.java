package com.upc.service;

import com.upc.entity.Usuario;

public interface UsuarioService {
	Iterable<Usuario> listAllUsuario();
	Usuario getUsuarioById(Integer id);
	Usuario saveUsuario(Usuario usuario);
	void deleteUsuario(Integer id);

	public Usuario findByUsernameAndPassword(String username, String password);

}
