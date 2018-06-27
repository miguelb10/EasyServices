package com.upc.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.upc.entity.Administrador;
import com.upc.entity.Empresa;
import com.upc.entity.Especialidad;
import com.upc.entity.ListaEmpleadoSolicitud;
import com.upc.entity.Pregunta;
import com.upc.entity.Usuario;
import com.upc.service.AdministradorService;
import com.upc.service.EspecialidadService;
import com.upc.service.ListaEmpleadoSolicitudService;
import com.upc.service.PreguntaService;

@Controller
public class AdministradorController {

	@Autowired
	private AdministradorService administradorService;
	@Autowired
	private ListaEmpleadoSolicitudService listaEmpleadoSolicitudService;
	@Autowired
	private EspecialidadService especialidadService;
	@Autowired
	private PreguntaService preguntaService;
	
	@RequestMapping("/administradorPerfil")
	public String findCompania(Model model, HttpSession session, ModelMap modelMap) {
		Administrador compa = administradorService.getAdministradorByUsuario((Usuario) session.getAttribute("usuarioSesion"));
		if(compa != null){
			session.setAttribute("admininistradorSession", compa);
			return "administrador_sesion";
			
		}else {
			return "usuario_sesion";			
		}		
	}
	
	@RequestMapping("/administradorTodosolicitud")
	public String administradorSolicitudes(Model model,ModelMap modelMap, HttpSession session) {
		Iterable<ListaEmpleadoSolicitud> listaSolicitud=listaEmpleadoSolicitudService.listAllListaEmpleadoSolicitud();
		model.addAttribute("listaSolicitudes", listaSolicitud);	
		return "administrador_todosolicitud";
	}
	
	@RequestMapping("/administradorEspecialidades")
	public String administradorEspecialidades(Model model,ModelMap modelMap, HttpSession session) {
		Iterable<Especialidad> listaEspecialidad=especialidadService.listAllEspecialidad();
		model.addAttribute("listaEspecialidades", listaEspecialidad);	
		return "administrador_especialidades";
	}
	
	@RequestMapping("/administradorPreguntas")
	public String administradorPreguntas(Model model,ModelMap modelMap, HttpSession session) {
		Iterable<Pregunta> listaPregunta=preguntaService.listAllPregunta();
		model.addAttribute("listaPreguntas", listaPregunta);	
		return "administrador_preguntas";
	}
	
	@RequestMapping(value = "/administradorConfiguracion", method = RequestMethod.GET)
	public String actualizarAdministrador(Model model,HttpSession session, ModelMap modelMap) {
		//modelMap.addAttribute("usuario", session.getAttribute("usuarioSesion"));
		return "administrador_configuracion";
	}
}
