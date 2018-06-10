package com.upc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.entity.Empresa;
import com.upc.entity.ListaSucursal;
import com.upc.repository.ListaSucursalRepository;

@Service
public class ListaSucursalServiceImpl implements ListaSucursalService{

	@Autowired
	private ListaSucursalRepository listaSucursalRepository;
	
	@Override
	public Iterable<ListaSucursal> listAllListaSucursal() {
		// TODO Auto-generated method stub
		return listaSucursalRepository.findAll();
	}

	@Override
	public ListaSucursal getListaSucursalById(Integer id) {
		// TODO Auto-generated method stub
		return listaSucursalRepository.findOne(id);
	}

	@Override
	public ListaSucursal saveListaSucursal(ListaSucursal listaSucursal) {
		// TODO Auto-generated method stub
		return listaSucursalRepository.save(listaSucursal);
	}

	@Override
	public void deleteListaSucursal(Integer id) {
		// TODO Auto-generated method stub
		listaSucursalRepository.delete(id);
	}

	@Override
	public Iterable<ListaSucursal> getListaSucursalByEmpresa(Empresa empresa) {
		// TODO Auto-generated method stub
		return listaSucursalRepository.findByEmpresa(empresa);
	}

}
