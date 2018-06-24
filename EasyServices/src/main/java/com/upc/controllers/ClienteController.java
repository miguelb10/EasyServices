package com.upc.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.upc.entity.Cliente;
import com.upc.entity.Empleado;
import com.upc.service.ClienteService;
import com.upc.service.EmpleadoService;

@Controller
public class ClienteController {
	@Autowired
	private ClienteService clienteService;
	
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
