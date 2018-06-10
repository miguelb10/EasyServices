package com.upc.service;

import com.upc.entity.TipoEmpresa;

public interface TipoEmpresaService {
	Iterable<TipoEmpresa> listAllTipoEmpresa();
	TipoEmpresa getTipoEmpresaById(Integer id);
	TipoEmpresa saveTipoEmpresa(TipoEmpresa tipoEmpresa);
	void deleteTipoEmpresa(Integer id);

}
