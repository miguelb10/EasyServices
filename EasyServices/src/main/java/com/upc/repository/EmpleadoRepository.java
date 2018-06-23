package com.upc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.upc.entity.Empleado;
import com.upc.entity.Usuario;

@Repository
@Transactional
public interface EmpleadoRepository extends CrudRepository<Empleado, Integer> {
	Empleado findByUsuario(Usuario usuario);
}
