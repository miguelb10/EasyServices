package com.upc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.entity.Empresa;
import com.upc.entity.ListaEmpleadoSolicitud;
import com.upc.repository.ListaEmpleadoSolicitudRepository;

@Service
public class ListaEmpleadoSolicitudServiceImpl implements ListaEmpleadoSolicitudService{

	@Autowired
	private ListaEmpleadoSolicitudRepository listaEmpleadoSolicitudRepository;
	
	@Override
	public Iterable<ListaEmpleadoSolicitud> listAllListaEmpleadoSolicitud() {
		// TODO Auto-generated method stub
		return listaEmpleadoSolicitudRepository.findAll();
	}

	@Override
	public ListaEmpleadoSolicitud getListaEmpleadoSolicitudById(Integer id) {
		// TODO Auto-generated method stub
		return listaEmpleadoSolicitudRepository.findOne(id);
	}

	@Override
	public ListaEmpleadoSolicitud saveListaEmpleadoSolicitud(ListaEmpleadoSolicitud listaEmpleadoSolicitud) {
		// TODO Auto-generated method stub
		return listaEmpleadoSolicitudRepository.save(listaEmpleadoSolicitud);
	}

	@Override
	public void deleteListaEmpleadoSolicitud(Integer id) {
		// TODO Auto-generated method stub
		listaEmpleadoSolicitudRepository.delete(id);
	}

	@Override
	public Iterable<ListaEmpleadoSolicitud> getListaEmpleadoSolicitudByPlantillaEmpresa(Empresa empresa) {
		// TODO Auto-generated method stub
		return listaEmpleadoSolicitudRepository.findByPlantillaEmpresa(empresa);
	}

}
