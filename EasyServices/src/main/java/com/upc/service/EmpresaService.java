package com.upc.service;

import com.upc.entity.Empresa;
import com.upc.entity.Usuario;

public interface EmpresaService {
	Iterable<Empresa> listAllEmpresa();
	Empresa getEmpresaById(Integer id);
	Empresa saveEmpresa(Empresa empresa);
	void deleteEmpresa(Integer id);

	Empresa getEmpresaByUsuario(Usuario usuario);
}
