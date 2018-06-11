package com.upc.service;

import com.upc.entity.Especialidad;

public interface EspecialidadService {
	Iterable<Especialidad> listAllEspecialidad();
	Especialidad getEspecialidadById(Integer id);
	Especialidad saveEspecialidad(Especialidad especialidad);
	void deleteEspecialidad(Integer id);

}
