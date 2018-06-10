package com.upc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.upc.entity.Administrador;
import com.upc.entity.Cliente;
import com.upc.entity.Usuario;

@Repository
@Transactional
public interface AdministradorRepository extends CrudRepository<Administrador, Integer> {
	List<Administrador> findByUsuario(Usuario usuario);
}
