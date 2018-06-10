package com.upc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.upc.entity.Empresa;
import com.upc.entity.ListaSucursal;

@Repository
@Transactional
public interface ListaSucursalRepository extends CrudRepository<ListaSucursal, Integer>{
	
	List<ListaSucursal> findByEmpresa(Empresa empresa);
}
