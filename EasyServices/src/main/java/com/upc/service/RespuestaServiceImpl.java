package com.upc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.entity.Respuesta;
import com.upc.repository.RespuestaRepository;

@Service
public class RespuestaServiceImpl implements RespuestaService{

	@Autowired
	private RespuestaRepository respuestaRepository;
	
	@Override
	public Iterable<Respuesta> listAllRespuesta() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Respuesta getRespuestaById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Respuesta saveRespuesta(Respuesta respuesta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRespuesta(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
