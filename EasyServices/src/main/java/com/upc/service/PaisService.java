package com.upc.service;

import com.upc.entity.Pais;

public interface PaisService {
	Iterable<Pais> listAllPais();
	Pais getPaisById(Integer id);
	Pais savePais(Pais pais);
	void deletePais(Integer id);

}
