package com.upc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.upc.entity.Cliente;
import com.upc.entity.Usuario;

@Repository
@Transactional
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
	Cliente findByUsuario(Usuario usuario);
}
