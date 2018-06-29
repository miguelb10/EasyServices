package com.upc.controllers;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.upc.entity.Cliente;
import com.upc.entity.Usuario;
import com.upc.service.CiudadService;
import com.upc.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private CiudadService ciudadService;

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(Model model,@ModelAttribute("usuario") Usuario usuario, HttpSession session, ModelMap modelMap) {
		if (usuarioService.findByUsernameAndPassword(usuario.getUsername(), usuario.getPassword()) != null) {
			Usuario usersession = usuarioService.findByUsernameAndPassword(usuario.getUsername(),
					usuario.getPassword());
			session.setAttribute("usuarioSesion", usersession);
			modelMap.addAttribute("usersession", session.getAttribute("usuarioSesion"));
			

			String[][] nombre = new String[2][1];
			
			nombre[0][0]="ho";
			nombre[1][0]="ho";
			model.addAttribute("nombre", nombre);
			
			
			return "usuario_sesion";
		} else {
			modelMap.put("error", "Usuario invalido");
			return "index";
		}
	}

	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("usuarios", usuarioService.listAllUsuario());
		return "usuarios";
	}

	@RequestMapping("/index_registrar")
	public String newUsuario(Model model) {
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("ciudades", ciudadService.listAllCiudad());
		return "index_registrar";
	}

	@RequestMapping(value = "/usuario_configuracion", method = RequestMethod.GET)
	public String actualizarUsuario(Model model,HttpSession session, ModelMap modelMap) {
		modelMap.addAttribute("usuario", session.getAttribute("usuarioSesion"));
		return "usuario_configuracion";
	}
	
	@RequestMapping(value = "/usuario", method = RequestMethod.POST)
	public String saveEntidad(Usuario usuario) {
		usuarioService.saveUsuario(usuario);
		return "redirect:/usuario_sesion";
	}
	
	@RequestMapping(value = "/usuarioRegistrar", method = RequestMethod.POST)
	public String saveUsuario(@ModelAttribute("usuario") Usuario usuario, ModelMap modelMap, HttpSession session) {
		try {
			usuarioService.saveUsuario(usuario);
			Usuario usersession = usuarioService.findByUsernameAndPassword(usuario.getUsername(),
					usuario.getPassword());
			session.setAttribute("usuarioSesion", usersession);
			modelMap.addAttribute("usersession", session.getAttribute("usuarioSesion"));
			return "usuario_sesion";
		} catch (Exception e) {
			return "/";
		}
	}

	@RequestMapping("/usuario_perfiles")
	public String usuarioPerfiles(Model model, HttpSession session, ModelMap modelMap) {		
		modelMap.addAttribute("usersession", session.getAttribute("usuarioSesion"));
		return "usuario_perfiles";
	}

	@RequestMapping("/usuario_preguntas")
	public String usuarioPreguntas(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		return "usuario_preguntas";
	}


	@RequestMapping("/usuario_sesion")
	public String usuarioSsion(Model model, HttpSession session) {
		model.addAttribute("usersession", session.getAttribute("usuarioSesion"));
		return "usuario_sesion";
	}
	@RequestMapping(value = "logout", method = RequestMethod.POST)
	public String logout(Model model,ModelMap modelMap) {	
		Usuario usuario=new Usuario();
		modelMap.remove("usuario",usuario);
		model.addAttribute("usuario",usuario );	
		return "index";
	}

}
