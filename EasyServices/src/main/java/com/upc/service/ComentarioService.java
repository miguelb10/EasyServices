package com.upc.service;

import com.upc.entity.Comentario;

public interface ComentarioService {
	Iterable<Comentario> listAllComentario();
	Comentario getComentarioById(Integer id);
	Comentario saveComentario(Comentario comentario);
	void deleteComentario(Integer id);

}
