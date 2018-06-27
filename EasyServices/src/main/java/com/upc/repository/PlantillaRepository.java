package com.upc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.upc.entity.Empresa;
import com.upc.entity.Plantilla;

@Repository
@Transactional
public interface PlantillaRepository extends CrudRepository<Plantilla, Integer> {

	List<Plantilla> findByEmpresa(Empresa empresa);
}
