package com.upc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.upc.entity.Empleado;
import com.upc.entity.Servicio;

@Repository
@Transactional
public interface ServicioRepository extends CrudRepository<Servicio, Integer>{

	List<Servicio> findByEmpleado(Empleado empleado);
}
