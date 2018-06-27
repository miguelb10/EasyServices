package com.upc.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.upc.entity.Cliente;
import com.upc.entity.Usuario;
import com.upc.service.CiudadService;
import com.upc.service.ClienteService;

@Controller
public class ClienteController {	

	@Autowired
	private CiudadService ciudadService;
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping("/indexCliente")
	public String indexAcerca(Model model) {
		Usuario usuario=new Usuario();
		model.addAttribute("usuario",usuario );
		return "indexCliente";
	}
	@RequestMapping("/clientePerfil")
	public String findCliente(Model model, HttpSession session, ModelMap modelMap) {
		Cliente clientel = clienteService.getClienteByUsuario((Usuario) session.getAttribute("usuarioSesion"));
		if(clientel != null){
			session.setAttribute("clienteSession", clientel);
			return "cliente_principal";
			
		}else {
			model.addAttribute("cliente", new Cliente());
			model.addAttribute("ciudades", ciudadService.listAllCiudad());
			return "cliente_registrar";			
		}		
	}
	@RequestMapping(value = "/clienteRegistrar", method = RequestMethod.POST)
	public String saveCliente(@ModelAttribute("cliente") Cliente cliente, HttpSession session, ModelMap modelMap) {		
		modelMap.addAttribute("usersession", session.getAttribute("usuarioSesion"));
		cliente.setUsuario((Usuario) session.getAttribute("usuarioSesion"));
		clienteService.saveCliente(cliente);
		session.setAttribute("clienteSession", cliente);
		return "cliente_principal";
	}
	
	@RequestMapping("/cliente_sesion")
	public String clienteSesion(ModelMap modelMap, HttpSession session,@RequestParam(value="id",required=false) Integer idcliente) {
		if(idcliente!=null) {
		Cliente clientesession=clienteService.getClienteById(idcliente);
		session.setAttribute("clienteSession", clientesession);
		}
		else
		{	
			idcliente=((Cliente)session.getAttribute("clienteSession")).getIdcliente();
		}
		return "cliente_sesion";
	}
	
}
