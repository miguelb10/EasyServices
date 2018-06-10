package com.upc.service;

import com.upc.entity.Ciudad;

public interface CiudadService {

	Iterable<Ciudad> listAllCiudad();
	Ciudad getCiudadById(Integer id);
	Ciudad saveCiudad(Ciudad ciudad);
	void deleteCiudad(Integer id);

}
