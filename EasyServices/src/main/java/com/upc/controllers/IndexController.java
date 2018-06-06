package com.upc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.upc.entity.Usuario;

@Controller
public class IndexController {
	@RequestMapping("/")
	public String index(Model model) {
		Usuario usuario=new Usuario();
		model.addAttribute("usuario",usuario );
		return "index";
	}
}