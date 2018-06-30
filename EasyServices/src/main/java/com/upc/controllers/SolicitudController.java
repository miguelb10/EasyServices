package com.upc.controllers;


import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.upc.entity.Solicitud;
import com.upc.entity.Usuario;
import com.upc.service.ClienteService;

@Controller
public class SolicitudController {
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(value="/solicitud/new/{idservicio}", method = RequestMethod.GET)
	public String newSolicitud(@PathVariable Integer idservicio, Model model, HttpSession session, ModelMap modelMap) {

		Solicitud solicitud=new Solicitud();
		model.addAttribute("idservicio", idservicio);
		model.addAttribute("solicitud", solicitud);
		return "newsolicitud";
	}

}
