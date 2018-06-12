package com.upc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.upc.entity.ListaSucursal;
import com.upc.entity.Plantilla;
import com.upc.entity.Servicio;
import com.upc.repository.PlantillaRepository;
import com.upc.service.EmpresaService;
import com.upc.service.ListaEmpleadoSolicitudService;
import com.upc.service.ListaSucursalService;
import com.upc.service.PlantillaService;
import com.upc.service.TipoEmpresaService;

@Controller
public class PerfilCompaniaController {

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
	
	
	//ListaSolicitudesCompañia
	@RequestMapping(value= "/EmpresaCompañia/Solicitud/{id}", method = RequestMethod.GET)
	public String listSolicitd(@PathVariable Integer id,Model model) {
		model.addAttribute("listaSolicitud", listaEmpleadoSolicitudService.getListaEmpleadoSolicitudByPlantillaEmpresa(empresaService.getEmpresaById(id)));
		return "listaSolicitud";
	}
	
	//PlantillaCompañia
	@RequestMapping(value= "/EmpresaCompañia/Plantilla/{id}", method = RequestMethod.GET)
	public String listPlantilla(@PathVariable Integer id,Model model) {
			model.addAttribute("listaPlantilla",plantillaService.getPlantillaByEmpresa(empresaService.getEmpresaById(id)));
			return "listaPlantilla";
	}
	
	@RequestMapping("/EmpresaCompañia/Plantilla/new")
	public String newPlantilla(Model model){
		model.addAttribute("plantilla", new Plantilla());
		return "plantilla";
	}
	
	@RequestMapping(value = "/EmpresaCompañia/Plantilla", method = RequestMethod.POST)
	public String savePlantilla(Plantilla plantilla){
		plantillaService.savePlantilla(plantilla);
		return "redirect:/EmpresaCompañia/Plantilla";
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
		
		@RequestMapping("/EmpresaCompañia/Sucursal/new")
		public String newSucursal(Model model){
			model.addAttribute("sucursal", new ListaSucursal());
			return "sucursal";
		}
		
		@RequestMapping(value = "/EmpresaCompañia/Sucursal", method = RequestMethod.POST)
		public String saveSucursal(ListaSucursal listaSucursal){
			listaSucursalService.saveListaSucursal(listaSucursal);
			return "redirect:/EmpresaCompañia/Sucursal";
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
