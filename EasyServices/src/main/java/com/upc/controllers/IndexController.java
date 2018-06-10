package com.upc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String index(Model model) {
		Usuario usuario=new Usuario();
		model.addAttribute("usuario",usuario );
		return "index";
	}
	
	
	
	
}