package com.upc.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.upc.entity.Administrador;
import com.upc.entity.Empresa;
import com.upc.entity.Especialidad;
import com.upc.entity.ListaEmpleadoSolicitud;
import com.upc.entity.Pregunta;
import com.upc.service.AdministradorService;
import com.upc.service.EmpresaService;
import com.upc.service.EspecialidadService;
import com.upc.service.ListaEmpleadoSolicitudService;
import com.upc.service.ListaSucursalService;
import com.upc.service.PlantillaService;
import com.upc.service.PreguntaService;
import com.upc.service.TipoEmpresaService;

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
	
	@RequestMapping("/administrador/sesion")
	public String administradorSesion(ModelMap modelMap, HttpSession session,@RequestParam(value="id",required=false) Integer idadministrador) {
		if(idadministrador!=null) {
		Administrador administradorsession=administradorService.getAdministradorById(idadministrador);
		session.setAttribute("administradorSession", administradorsession);
		}
		else
		{	
			idadministrador=((Administrador)session.getAttribute("administradorSession")).getIdadministrador();
		}
		return "administrador_sesion";
	}
	
	@RequestMapping("/administrador/todosolicitud")
	public String administradorSolicitudes(Model model,ModelMap modelMap, HttpSession session) {
		Iterable<ListaEmpleadoSolicitud> listaSolicitud=listaEmpleadoSolicitudService.listAllListaEmpleadoSolicitud();
		model.addAttribute("listaSolicitudes", listaSolicitud);	
		return "administrador_todosolicitud";
	}
	
	@RequestMapping("/administrador/especialidades")
	public String administradorEspecialidades(Model model,ModelMap modelMap, HttpSession session) {
		Iterable<Especialidad> listaEspecialidad=especialidadService.listAllEspecialidad();
		model.addAttribute("listaEspecialidades", listaEspecialidad);	
		return "administrador_especialidades";
	}
	
	@RequestMapping("/administrador/preguntas")
	public String administradorPreguntas(Model model,ModelMap modelMap, HttpSession session) {
		Iterable<Pregunta> listaPregunta=preguntaService.listAllPregunta();
		model.addAttribute("listaPreguntas", listaPregunta);	
		return "administrador_preguntas";
	}
	
	@RequestMapping(value = "/administrador/configuracion", method = RequestMethod.GET)
	public String actualizarAdministrador(Model model,HttpSession session, ModelMap modelMap) {
		//modelMap.addAttribute("usuario", session.getAttribute("usuarioSesion"));
		return "administrador_configuracion";
	}
}
