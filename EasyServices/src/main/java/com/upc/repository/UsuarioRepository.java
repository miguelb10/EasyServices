package com.upc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.upc.entity.Usuario;

@Repository
@Transactional
public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
	
	public Usuario findByUsernameAndPassword(String username, String password);
}
