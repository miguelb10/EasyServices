package com.upc.service;

import com.upc.entity.EstadoValidar;

public interface EstadoValidarService {
	Iterable<EstadoValidar> listAllEstadoValidar();
	EstadoValidar getEstadoValidarById(Integer id);
	EstadoValidar saveEstadoValidar(EstadoValidar estadoValidar);
	void deleteEstadoValidar(Integer id);

}
