package com.upc.service;

import com.upc.entity.Pregunta;

public interface PreguntaService {
	Iterable<Pregunta> listAllPregunta();
	Pregunta getPreguntaById(Integer id);
	Pregunta savePregunta(Pregunta pregunta);
	void deletePregunta(Integer id);

}
