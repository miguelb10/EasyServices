package com.upc.service;

import com.upc.entity.Empresa;
import com.upc.entity.ListaEmpleadoSolicitud;

public interface ListaEmpleadoSolicitudService {
	Iterable<ListaEmpleadoSolicitud> listAllListaEmpleadoSolicitud();
	ListaEmpleadoSolicitud getListaEmpleadoSolicitudById(Integer id);
	ListaEmpleadoSolicitud saveListaEmpleadoSolicitud(ListaEmpleadoSolicitud listaEmpleadoSolicitud);
	void deleteListaEmpleadoSolicitud(Integer id);
	
	Iterable<ListaEmpleadoSolicitud> getListaEmpleadoSolicitudByPlantillaEmpresa(Empresa empresa);

}
