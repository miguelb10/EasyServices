package com.upc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.upc.entity.Empresa;
import com.upc.entity.Servicio;
import com.upc.entity.TipoEmpresa;
import com.upc.entity.Usuario;

@Repository
@Transactional
public interface EmpresaRepository extends CrudRepository<Empresa, Integer>{

	List<Empresa> findByUsuarioAndTipoEmpresa(Usuario usuario,TipoEmpresa tipoEmpresa);
}
