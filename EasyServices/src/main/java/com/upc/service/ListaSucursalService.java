package com.upc.service;

import com.upc.entity.Empresa;
import com.upc.entity.ListaSucursal;

public interface ListaSucursalService {
	Iterable<ListaSucursal> listAllListaSucursal();
	ListaSucursal getListaSucursalById(Integer id);
	ListaSucursal saveListaSucursal(ListaSucursal listaSucursal);
	void deleteListaSucursal(Integer id);

	Iterable<ListaSucursal> getListaSucursalByEmpresa(Empresa empresa);
}
