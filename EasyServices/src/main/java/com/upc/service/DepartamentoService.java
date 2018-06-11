package com.upc.service;

import com.upc.entity.Departamento;

public interface DepartamentoService {
	Iterable<Departamento> listAllDepartamento();
	Departamento getDepartamentoById(Integer id);
	Departamento saveDepartamento(Departamento departamento);
	void deleteDepartamento(Integer id);

}
