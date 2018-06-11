package com.upc.service;

import com.upc.entity.Empresa;
import com.upc.entity.Plantilla;

public interface PlantillaService {
	Iterable<Plantilla> listAllPlantilla();
	Plantilla getPlantillaById(Integer id);
	Plantilla savePlantilla(Plantilla plantilla);
	void deletePlantilla(Integer id);
	
	Iterable<Plantilla> getPlantillaByEmpresa(Empresa empresa);
}
