package com.upc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.entity.Pregunta;
import com.upc.repository.PreguntaRepository;

@Service
public class PreguntaServiceImpl implements PreguntaService{

	@Autowired
	private PreguntaRepository preguntaRepository;
	
	@Override
	public Iterable<Pregunta> listAllPregunta() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pregunta getPreguntaById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pregunta savePregunta(Pregunta pregunta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePregunta(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
