package com.upc.service;

import com.upc.entity.Empresa;
import com.upc.entity.Servicio;

public interface ServicioService {
	Iterable<Servicio> listAllServicio();
	Servicio getServicioById(Integer id);
	Servicio saveServicio(Servicio servicio);
	void deleteServicio(Integer id);

	Iterable<Servicio> getServicioByEmpresa(Empresa empresa);
}
