package com.upc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.upc.entity.Empresa;
import com.upc.entity.TipoEmpresa;
import com.upc.entity.Usuario;

public interface EmpresaService {
	Iterable<Empresa> listAllEmpresa();
	Empresa getEmpresaById(Integer id);
	Empresa saveEmpresa(Empresa empresa);
	void deleteEmpresa(Integer id);

	Iterable<Empresa> getEmpresaByUsuarioAndTipoEmpresa(Usuario usuario,TipoEmpresa tipoEmpresa);
}
