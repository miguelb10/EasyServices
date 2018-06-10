package com.upc.service;

import com.upc.entity.Respuesta;

public interface RespuestaService {
	Iterable<Respuesta> listAllRespuesta();
	Respuesta getRespuestaById(Integer id);
	Respuesta saveRespuesta(Respuesta respuesta);
	void deleteRespuesta(Integer id);

}
