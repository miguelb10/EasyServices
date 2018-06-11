package com.upc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.entity.Solicitud;
import com.upc.repository.SolicitudRepository;

@Service
public class SolicitudServiceImpl implements SolicitudService{

	@Autowired
	private SolicitudRepository solicitudRepository;
	
	@Override
	public Iterable<Solicitud> listAllSolicitud() {
		// TODO Auto-generated method stub
		return solicitudRepository.findAll();
	}

	@Override
	public Solicitud getSolicitudById(Integer id) {
		// TODO Auto-generated method stub
		return solicitudRepository.findOne(id);
	}

	@Override
	public Solicitud saveSolicitud(Solicitud solicitud) {
		// TODO Auto-generated method stub
		return solicitudRepository.save(solicitud);
	}

	@Override
	public void deleteSolicitud(Integer id) {
		// TODO Auto-generated method stub
		solicitudRepository.delete(id);
	}

}
