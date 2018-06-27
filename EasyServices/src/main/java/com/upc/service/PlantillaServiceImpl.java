package com.upc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.entity.Empresa;
import com.upc.entity.Plantilla;
import com.upc.repository.PlantillaRepository;

@Service
public class PlantillaServiceImpl implements PlantillaService{

	@Autowired
	private PlantillaRepository plantillaRepository;
	
	@Override
	public Iterable<Plantilla> listAllPlantilla() {
		// TODO Auto-generated method stub
		return plantillaRepository.findAll();
	}

	@Override
	public Plantilla getPlantillaById(Integer id) {
		// TODO Auto-generated method stub
		return plantillaRepository.findOne(id);
	}

	@Override
	public Plantilla savePlantilla(Plantilla plantilla) {
		// TODO Auto-generated method stub
		return plantillaRepository.save(plantilla);
	}

	@Override
	public void deletePlantilla(Integer id) {
		// TODO Auto-generated method stub
		plantillaRepository.delete(id);
	}

	@Override
	public Iterable<Plantilla> getPlantillaByEmpresa(Empresa empresa) {
		// TODO Auto-generated method stub
		return plantillaRepository.findByEmpresa(empresa);
	}

}
