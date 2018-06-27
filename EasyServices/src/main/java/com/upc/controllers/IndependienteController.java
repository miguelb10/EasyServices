package com.upc.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.upc.entity.Empresa;
import com.upc.entity.ListaEmpleadoSolicitud;
import com.upc.entity.Plantilla;
import com.upc.entity.Usuario;
import com.upc.service.CiudadService;
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
	@Autowired
	private CiudadService ciudadService;
	
	@RequestMapping("/EmpresaIndependientePerfil")
	public String findCompania(Model model, HttpSession session, ModelMap modelMap) {
		Empresa compa = empresaService.getEmpresaByUsuarioAndTipoEmpresa((Usuario) session.getAttribute("usuarioSesion"),tipoEmpresaService.getTipoEmpresaById(2));
		if(compa != null){
			session.setAttribute("empresaSession", compa);
			return "independiente_sesion";
			
		}else {
			model.addAttribute("empresa", new Empresa());
			model.addAttribute("ciudades", ciudadService.listAllCiudad());
			model.addAttribute("tipoempresas", tipoEmpresaService.listAllTipoEmpresa());
			return "compania_registrar";			
		}		
	}
	
	
	@RequestMapping("/independienteMisolicitudes")
	public String independienteSolicitudes(Model model,ModelMap modelMap, HttpSession session) {
		Iterable<ListaEmpleadoSolicitud> listaSolicitud=listaEmpleadoSolicitudService.getListaEmpleadoSolicitudByPlantillaListaSucursalEmpresa((Empresa)session.getAttribute("empresaSession"));
		model.addAttribute("listaSolicitudes", listaSolicitud);	
		return "independiente_misolicitudes";
	}
	
	@RequestMapping("/independienteServicios")
	public String independienteServicios(Model model,ModelMap modelMap, HttpSession session) {
		Iterable<Plantilla> listaPlantilla=plantillaService.getPlantillaByListaSucursalEmpresa((Empresa)session.getAttribute("empresaSession"));
		model.addAttribute("listaEmpleados", listaPlantilla);	
		return "independiente_servicios";
	}
	
	@RequestMapping(value = "/independienteConfiguracion", method = RequestMethod.GET)
	public String actualizarIndependiente(Model model,HttpSession session, ModelMap modelMap) {
		//modelMap.addAttribute("usuario", session.getAttribute("usuarioSesion"));
		return "independiente_configuracion";
	}
}
