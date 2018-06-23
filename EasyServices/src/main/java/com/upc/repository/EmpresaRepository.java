package com.upc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.upc.entity.Empresa;
import com.upc.entity.Usuario;

@Repository
@Transactional
public interface EmpresaRepository extends CrudRepository<Empresa, Integer>{

	Empresa findByUsuario(Usuario usuario);
}
