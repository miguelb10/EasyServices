package com.upc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.entity.TipoEmpresa;
import com.upc.repository.TipoEmpresaRepository;

@Service
public class TipoEmpresaServiceImpl implements TipoEmpresaService{

	@Autowired
	private TipoEmpresaRepository tipoEmpresaRepository;
	
	@Override
	public Iterable<TipoEmpresa> listAllTipoEmpresa() {
		// TODO Auto-generated method stub
		return tipoEmpresaRepository.findAll();
	}

	@Override
	public TipoEmpresa getTipoEmpresaById(Integer id) {
		// TODO Auto-generated method stub
		return tipoEmpresaRepository.findOne(id);
	}

	@Override
	public TipoEmpresa saveTipoEmpresa(TipoEmpresa tipoEmpresa) {
		// TODO Auto-generated method stub
		return tipoEmpresaRepository.save(tipoEmpresa);
	}

	@Override
	public void deleteTipoEmpresa(Integer id) {
		// TODO Auto-generated method stub
		tipoEmpresaRepository.delete(id);
	}

}
