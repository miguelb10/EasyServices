package com.upc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.entity.Empresa;
import com.upc.entity.TipoEmpresa;
import com.upc.entity.Usuario;
import com.upc.repository.EmpresaRepository;

@Service
public class EmpresaServiceImpl implements EmpresaService{

	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Override
	public Iterable<Empresa> listAllEmpresa() {
		// TODO Auto-generated method stub
		return empresaRepository.findAll();
	}

	@Override
	public Empresa getEmpresaById(Integer id) {
		// TODO Auto-generated method stub
		return empresaRepository.findOne(id);
	}

	@Override
	public Empresa saveEmpresa(Empresa empresa) {
		// TODO Auto-generated method stub
		return empresaRepository.save(empresa);
	}

	@Override	
	public void deleteEmpresa(Integer id) {
		// TODO Auto-generated method stub
		empresaRepository.delete(id);
	}

	@Override
	public Iterable<Empresa> getEmpresaByUsuarioAndTipoEmpresa(Usuario usuario, TipoEmpresa tipoEmpresa) {
		// TODO Auto-generated method stub
		return empresaRepository.findByUsuarioAndTipoEmpresa(usuario, tipoEmpresa);
	}




}
