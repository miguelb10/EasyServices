package com.upc.service;

import com.upc.entity.Administrador;
import com.upc.entity.Empresa;
import com.upc.entity.TipoEmpresa;
import com.upc.entity.Usuario;

public interface AdministradorService {
	Iterable<Administrador> listAllAdministrador();
	Administrador getAdministradorById(Integer id);
	Administrador saveAdministrador(Administrador administrador);
	void deleteAdministrador(Integer id);

	Iterable<Administrador> getEmpresaByUsuario(Usuario usuario);
}
