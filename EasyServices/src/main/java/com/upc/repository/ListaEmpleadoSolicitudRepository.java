package com.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.upc.entity.Empresa;
import com.upc.entity.ListaEmpleadoSolicitud;
import com.upc.entity.Plantilla;
import com.upc.entity.TipoEmpresa;
import com.upc.entity.Usuario;

@Repository
@Transactional
public interface ListaEmpleadoSolicitudRepository extends CrudRepository<ListaEmpleadoSolicitud, Integer> {

	List<ListaEmpleadoSolicitud> findByPlantillaEmpresa(Empresa empresa);
}
