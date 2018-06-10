package com.upc.service;

import com.upc.entity.EstadoProceso;

public interface EstadoProcesoService {
	Iterable<EstadoProceso> listAllEstadoProceso();
	EstadoProceso getEstadoProcesoById(Integer id);
	EstadoProceso saveEstadoProceso(EstadoProceso estadoProceso);
	void deleteEstadoProceso(Integer id);

}
