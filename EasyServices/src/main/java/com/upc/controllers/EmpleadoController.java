package com.upc.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.upc.entity.Empleado;
import com.upc.entity.Usuario;
import com.upc.service.CiudadService;
import com.upc.service.EmpleadoService;

@Controller
public class EmpleadoController {
	
	@Autowired
	private EmpleadoService empleadoService;
	@Autowired
	private CiudadService ciudadService;
	
	@RequestMapping("/empleadoPerfil")
	public String findEmpleado(Model model, HttpSession session, ModelMap modelMap) {
		Empleado empl = empleadoService.getEmpleadoByUsuario((Usuario) session.getAttribute("usuarioSesion"));
		if(empl != null){
			session.setAttribute("empleadoSession", empl);
			return "empleado_principal";
			
		}else {
			model.addAttribute("empleado", new Empleado());
			model.addAttribute("ciudades", ciudadService.listAllCiudad());
			return "empleado_registrar";			
		}		
	}
	@RequestMapping(value = "/empleadoRegistrar", method = RequestMethod.POST)
	public String saveCliente(@ModelAttribute("empleado") Empleado empleado, HttpSession session, ModelMap modelMap) {		
		modelMap.addAttribute("usersession", session.getAttribute("usuarioSesion"));
		empleado.setUsuario((Usuario) session.getAttribute("usuarioSesion"));
		empleadoService.saveEmpleado(empleado);
		session.setAttribute("empleadoSession", empleado);
		return "empleado_principal";
	}

}
