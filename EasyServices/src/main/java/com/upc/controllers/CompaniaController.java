package com.upc.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.upc.entity.Empresa;
import com.upc.entity.ListaEmpleadoSolicitud;
import com.upc.entity.ListaSucursal;
import com.upc.entity.Plantilla;
import com.upc.entity.Servicio;
import com.upc.repository.PlantillaRepository;
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
	
	@RequestMapping("/compania/sesion")
	public String companiaSesion(ModelMap modelMap, HttpSession session,@RequestParam(value="id",required=false) Integer idempresa) {
		if(idempresa!=null) {
		Empresa empresasession=empresaService.getEmpresaById(idempresa);
		session.setAttribute("empresaSession", empresasession);
		}
		else
		{	
			idempresa=((Empresa)session.getAttribute("empresaSession")).getIdempresa();
		}
		return "compania_sesion";
	}
	
	@RequestMapping("/compania/sucursales")
	public String companiaSucursales(Model model,ModelMap modelMap, HttpSession session) {
		Iterable<ListaSucursal> listaSucursal=listaSucursalService.getListaSucursalByEmpresa((Empresa)session.getAttribute("empresaSession"));
		model.addAttribute("listaSucursales", listaSucursal);	
		return "compania_sucursales";
	}
	
	@RequestMapping("/compania/plantilla")
	public String companiaPlantilla(Model model,ModelMap modelMap, HttpSession session) {
		Iterable<Plantilla> listaPlantilla=plantillaService.getPlantillaByListaSucursalEmpresa((Empresa)session.getAttribute("empresaSession"));
		model.addAttribute("listaEmpleados", listaPlantilla);	
		return "compania_plantilla";
	}
	
	@RequestMapping("/compania/solicitudes")
	public String companiaSolicitudes(Model model,ModelMap modelMap, HttpSession session) {
		Iterable<ListaEmpleadoSolicitud> listaSolicitud=listaEmpleadoSolicitudService.getListaEmpleadoSolicitudByPlantillaListaSucursalEmpresa((Empresa)session.getAttribute("empresaSession"));
		model.addAttribute("listaSolicitudes", listaSolicitud);	
		return "compania_misolicitudes";
	}
	
	@RequestMapping(value = "/compania/configuracion", method = RequestMethod.GET)
	public String actualizarCompania(Model model,HttpSession session, ModelMap modelMap) {
		//modelMap.addAttribute("usuario", session.getAttribute("usuarioSesion"));
		return "compania_configuracion";
	}
	
	@RequestMapping("/compania/sucursales/nuevo")
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
		return "redirect:/compania/sesion";
	}
	
	@RequestMapping("/compania/plantilla/nuevo")
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
		return "redirect:/compania/sesion";
	}
	
	//ListaSolicitudesCompañia
	@RequestMapping(value= "/EmpresaCompañia/Solicitud/{id}", method = RequestMethod.GET)
	public String listSolicitd(@PathVariable Integer id,Model model) {
		model.addAttribute("listaSolicitud", listaEmpleadoSolicitudService.getListaEmpleadoSolicitudByPlantillaListaSucursalEmpresa(empresaService.getEmpresaById(id)));
		return "listaSolicitud";
	}
	
	//PlantillaCompañia
	@RequestMapping(value= "/EmpresaCompañia/Plantilla/{id}", method = RequestMethod.GET)
	public String listPlantilla(@PathVariable Integer id,Model model) {
			model.addAttribute("listaPlantilla",plantillaService.getPlantillaByListaSucursalEmpresa(empresaService.getEmpresaById(id)));
			return "listaPlantilla";
	}
	
	@RequestMapping(value= "/EmpresaCompañia/Plantilla/edit/{id}", method = RequestMethod.GET)
	public String editPlantilla(@PathVariable Integer id, Model model){
		Plantilla plantilla = plantillaService.getPlantillaById(id);
		model.addAttribute("plantilla", plantilla);
		return "plantilla";
	}
	
	@RequestMapping("/EmpresaCompañia/Plantilla/delete/{id}")
	public String deletePlantilla(@PathVariable Integer id){
		plantillaService.deletePlantilla(id);
		return "redirect:/EmpresaCompañia/Plantilla";
	}
	
	//SucursalCompañia
		@RequestMapping(value= "/EmpresaCompañia/Sucursal/{id}", method = RequestMethod.GET)
		public String listSucursal(@PathVariable Integer id,Model model) {
				model.addAttribute("listaSucursal",listaSucursalService.getListaSucursalByEmpresa(empresaService.getEmpresaById(id)));
				return "listaSucursal";
		}
		
		
		
		@RequestMapping(value= "/EmpresaCompañia/Sucursal/edit/{id}", method = RequestMethod.GET)
		public String editSucursal(@PathVariable Integer id, Model model){
			ListaSucursal sucursal =listaSucursalService.getListaSucursalById(id);
			model.addAttribute("listaSucursal", sucursal);
			return "listaSucursal";
		}
		
		@RequestMapping("/EmpresaCompañia/Sucursal/delete/{id}")
		public String deleteSucursal(@PathVariable Integer id){
			listaSucursalService.getListaSucursalById(id);
			return "redirect:/EmpresaCompañia/Sucursal";
		}
}
