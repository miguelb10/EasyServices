package com.upc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.entity.Comentario;
import com.upc.repository.ComentarioRepository;

@Service
public class ComentarioServiceImpl implements ComentarioService{

	@Autowired
	private ComentarioRepository comentarioRepository;
	
	@Override
	public Iterable<Comentario> listAllComentario() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comentario getComentarioById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comentario saveComentario(Comentario comentario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteComentario(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
