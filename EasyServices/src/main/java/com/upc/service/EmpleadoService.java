package com.upc.service;

import com.upc.entity.Administrador;
import com.upc.entity.Empleado;
import com.upc.entity.Usuario;

public interface EmpleadoService {
	Iterable<Empleado> listAllEmpleado();
	Empleado getEmpleadoById(Integer id);
	Empleado saveEmpleado(Empleado empleado);
	void deleteEmpleado(Integer id);

	Iterable<Empleado> getEmpresaByUsuario(Usuario usuario);
}
