package com.upc.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.upc.entity.Usuario;
import com.upc.service.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value= "login", method = RequestMethod.POST)
	public String login(
			@ModelAttribute("usuario") Usuario usuario,
			HttpSession session, ModelMap modelMap) {
		if(usuarioService.findByUsernameAndPassword(usuario.getUsername(), usuario.getPassword()) != null){
			session.setAttribute("username", usuario.getUsername());
			return "clienteprincipal";
		}else{
			modelMap.put("error", "Usuario invalido");
			return "index";			
		}
	}	
	/*@RequestMapping("login")
	public String newIncidente(Model model){
		model.addAttribute("login", new Usuario());
		return "login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(Usuario usuario){
		usuarioService.saveUsuario(usuario);
		return "login";
	}*/
	
	@RequestMapping(value= "/usuarios", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("usuarios", usuarioService.listAllUsuario());
		return "usuarios";
	}
	

}
