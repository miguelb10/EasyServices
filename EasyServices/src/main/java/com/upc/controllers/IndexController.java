package com.upc.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.upc.entity.Usuario;

@Controller
public class IndexController {
	
	@RequestMapping("/index_acerca")
	public String indexAcerca(Model model) {
		Usuario usuario=new Usuario();
		model.addAttribute("usuario",usuario );
		return "index_acerca";
	}
	
	@RequestMapping("/index_buscar")
	public String indexBuscar(Model model) {
		Usuario usuario=new Usuario();
		model.addAttribute("usuario",usuario );
		return "index_buscar";
	}
	
	@RequestMapping("/index_easyservices")
	public String indexEasyservices(Model model) {
		Usuario usuario=new Usuario();
		model.addAttribute("usuario",usuario );
		return "index_easyservices";
	}
	
	@RequestMapping("/index_ubicanos")
	public String indexUbicanos(Model model) {
		Usuario usuario=new Usuario();
		model.addAttribute("usuario",usuario );
		return "index_ubicanos";
	}
	
	@RequestMapping("/")
	public String index(Model model, HttpSession session, ModelMap modelMap) {
		if(session.getAttribute("usuarioSesion") != null) {
			modelMap.addAttribute("usersession", session.getAttribute("usuarioSesion"));
			return  "usuario_sesion";
		}
		else {
			Usuario usuario=new Usuario();
			model.addAttribute("usuario",usuario );
			return "index";			
		}
	}
	
	
	
	
}