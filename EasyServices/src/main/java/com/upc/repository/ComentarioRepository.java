package com.upc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.upc.entity.Comentario;

@Repository
@Transactional
public interface ComentarioRepository extends CrudRepository<Comentario, Integer> {

}
