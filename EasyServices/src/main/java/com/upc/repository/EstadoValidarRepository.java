package com.upc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.upc.entity.EstadoValidar;

@Repository
@Transactional
public interface EstadoValidarRepository extends CrudRepository<EstadoValidar, Integer> {

}
