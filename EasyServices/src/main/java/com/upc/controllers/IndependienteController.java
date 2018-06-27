package com.upc.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.upc.entity.Administrador;
import com.upc.entity.Empresa;
import com.upc.entity.Especialidad;
import com.upc.entity.ListaEmpleadoSolicitud;
import com.upc.entity.Plantilla;
import com.upc.entity.Pregunta;
import com.upc.service.AdministradorService;
=======
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.upc.entity.Empresa;
import com.upc.entity.ListaEmpleadoSolicitud;
import com.upc.entity.Plantilla;
import com.upc.entity.Usuario;
import com.upc.service.CiudadService;
>>>>>>> CristianUnir
import com.upc.service.EmpresaService;
import com.upc.service.ListaEmpleadoSolicitudService;
import com.upc.service.ListaSucursalService;
import com.upc.service.PlantillaService;
import com.upc.service.TipoEmpresaService;

@Controller
public class IndependienteController {

	@Autowired
	private TipoEmpresaService tipoEmpresaService;
	@Autowired
	private ListaEmpleadoSolicitudService listaEmpleadoSolicitudService;
	@Autowired
	private PlantillaService plantillaService;
	@Autowired
	private ListaSucursalService listaSucursalService;
	@Autowired
	private EmpresaService empresaService;
	
	@RequestMapping("/independiente/sesion")
	public String independienteSesion(ModelMap modelMap, HttpSession session,@RequestParam(value="id",required=false) Integer idempresa) {
		if(idempresa!=null) {
		Empresa empresasession=empresaService.getEmpresaById(idempresa);
		session.setAttribute("empresaSession", empresasession);
		}
		else
		{	
			idempresa=((Empresa)session.getAttribute("empresaSession")).getIdempresa();
		}
		return "independiente_sesion";
	}
	
	@RequestMapping("/independiente/misolicitudes")
	public String independienteSolicitudes(Model model,ModelMap modelMap, HttpSession session) {
		Iterable<ListaEmpleadoSolicitud> listaSolicitud=listaEmpleadoSolicitudService.getListaEmpleadoSolicitudByPlantillaListaSucursalEmpresa((Empresa)session.getAttribute("empresaSession"));
		model.addAttribute("listaSolicitudes", listaSolicitud);	
		return "independiente_misolicitudes";
	}
	
	@RequestMapping("/independiente/servicios")
	public String independienteServicios(Model model,ModelMap modelMap, HttpSession session) {
		Iterable<Plantilla> listaPlantilla=plantillaService.getPlantillaByListaSucursalEmpresa((Empresa)session.getAttribute("empresaSession"));
		model.addAttribute("listaEmpleados", listaPlantilla);	
		return "independiente_servicios";
	}
	
	@RequestMapping(value = "/independiente/configuracion", method = RequestMethod.GET)
	public String actualizarIndependiente(Model model,HttpSession session, ModelMap modelMap) {
		//modelMap.addAttribute("usuario", session.getAttribute("usuarioSesion"));
		return "independiente_configuracion";
	}
}
