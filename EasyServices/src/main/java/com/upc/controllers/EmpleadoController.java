package com.upc.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.upc.entity.Empleado;
import com.upc.entity.Empresa;
import com.upc.service.EmpleadoService;
import com.upc.service.EmpresaService;

@Controller
public class EmpleadoController {
	@Autowired
	private EmpleadoService empleadoService;
	
	@RequestMapping("/empleado_sesion")
	public String empleadoSesion(ModelMap modelMap, HttpSession session,@RequestParam(value="id",required=false) Integer idempleado) {
		if(idempleado!=null) {
		Empleado empleadosession=empleadoService.getEmpleadoById(idempleado);
		session.setAttribute("empleadoSession", empleadosession);
		}
		else
		{	
			idempleado=((Empleado)session.getAttribute("empleadoSession")).getIdempleado();
		}
		return "empleado_sesion";
	}
}
