package com.upc.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.upc.entity.Cliente;
import com.upc.entity.Empresa;
import com.upc.entity.ListaEmpleadoSolicitud;
import com.upc.entity.ListaSucursal;
import com.upc.entity.Plantilla;
import com.upc.entity.Usuario;
import com.upc.service.CiudadService;
import com.upc.service.EmpresaService;
import com.upc.service.EstadoValidarService;
import com.upc.service.ListaEmpleadoSolicitudService;
import com.upc.service.ListaSucursalService;
import com.upc.service.PlantillaService;
import com.upc.service.ServicioService;
import com.upc.service.TipoEmpresaService;

@Controller
public class CompaniaController {

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
	@Autowired
	private ServicioService servicioService;
	@Autowired
	private EstadoValidarService estadoValidarService;
	
	@RequestMapping("/EmpresaCompaniaPerfil")
	public String findCompania(Model model, HttpSession session, ModelMap modelMap) {
		Empresa compa = empresaService.getEmpresaByUsuarioAndTipoEmpresa((Usuario) session.getAttribute("usuarioSesion"),tipoEmpresaService.getTipoEmpresaById(1));
		if(compa != null){
			session.setAttribute("empresaSession", compa);
			return "compania_sesion";
			
		}else {
			model.addAttribute("empresa", new Empresa());
			model.addAttribute("ciudades", ciudadService.listAllCiudad());
			model.addAttribute("tipoempresas", tipoEmpresaService.listAllTipoEmpresa());
			return "compania_registrar";			
		}		
	}
	
	@RequestMapping(value = "/companiaRegistrar", method = RequestMethod.POST)
	public String saveCompania(@ModelAttribute("empresa") Empresa empresa, HttpSession session, ModelMap modelMap) {		
		modelMap.addAttribute("usersession", session.getAttribute("usuarioSesion"));
		empresa.setUsuario((Usuario) session.getAttribute("usuarioSesion"));
		empresa.setCalificacion(3);
		empresaService.saveEmpresa(empresa);
		session.setAttribute("empresaSession", empresa);
		if(empresa.getTipoEmpresa().getIdtipo_empresa()==1)
			return "redirect:/EmpresaCompaniaPerfil";
		else if(empresa.getTipoEmpresa().getIdtipo_empresa()==2)
			return "redirect:/EmpresaIndependientePerfil";
		else
			return "usuario_sesion";
	}
	
	@RequestMapping("/companiaSucursales")
	public String companiaSucursales(Model model,ModelMap modelMap, HttpSession session) {
		Iterable<ListaSucursal> listaSucursal=listaSucursalService.getListaSucursalByEmpresa((Empresa)session.getAttribute("empresaSession"));
		model.addAttribute("listaSucursales", listaSucursal);	
		return "compania_sucursales";
	}
	
	@RequestMapping("/companiaPlantilla")
	public String companiaPlantilla(Model model,ModelMap modelMap, HttpSession session) {
		Iterable<Plantilla> listaPlantilla=plantillaService.getPlantillaByListaSucursalEmpresa((Empresa)session.getAttribute("empresaSession"));
		model.addAttribute("listaEmpleados", listaPlantilla);	
		return "compania_plantilla";
	}
	
	@RequestMapping("/companiaSolicitudes")
	public String companiaSolicitudes(Model model,ModelMap modelMap, HttpSession session) {
		Iterable<ListaEmpleadoSolicitud> listaSolicitud=listaEmpleadoSolicitudService.getListaEmpleadoSolicitudByPlantillaListaSucursalEmpresa((Empresa)session.getAttribute("empresaSession"));
		model.addAttribute("listaSolicitudes", listaSolicitud);	
		return "compania_misolicitudes";
	}
	
	@RequestMapping(value = "/companiaConfiguracion", method = RequestMethod.GET)
	public String actualizarCompania(Model model,HttpSession session, ModelMap modelMap) {
		//modelMap.addAttribute("usuario", session.getAttribute("usuarioSesion"));
		return "compania_configuracion";
	}
	
	@RequestMapping("/companiaSucursalesNuevo")
	public String newSucursal(Model model,HttpSession session,ModelMap modelMap){
		ListaSucursal listaSucursal=new ListaSucursal();
		listaSucursal.setEmpresa((Empresa)session.getAttribute("empresaSession"));
		modelMap.addAttribute("listaSucursal", listaSucursal);
		model.addAttribute("ciudades", ciudadService.listAllCiudad());
		return "compania_sucursales_agregar";
	}
	
	@RequestMapping(value = "/sucursalRegistrar", method = RequestMethod.POST)
	public String saveSucursal(ListaSucursal listaSucursal){
		listaSucursalService.saveListaSucursal(listaSucursal);
		return "redirect:/EmpresaCompaniaPerfil";
	}
	
	@RequestMapping("/companiaPlantillaNuevo")
	public String newPlantilla(Model model,HttpSession session,ModelMap modelMap){
		Plantilla plantilla=new Plantilla();
		plantilla.setEstadoValidar(estadoValidarService.getEstadoValidarById(2));
		modelMap.addAttribute("plantilla", plantilla);
		model.addAttribute("sucursales", listaSucursalService.getListaSucursalByEmpresa((Empresa)session.getAttribute("empresaSession")));
		model.addAttribute("servicios", servicioService.listAllServicio());
		return "compania_plantilla_agregar";
	}
	
	@RequestMapping(value = "/plantillaRegistrar", method = RequestMethod.POST)
	public String savePlantilla(Plantilla plantilla){
		plantillaService.savePlantilla(plantilla);
		return "redirect:/EmpresaCompaniaPerfil";
	}
}
