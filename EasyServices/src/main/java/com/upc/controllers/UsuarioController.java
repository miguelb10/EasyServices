package com.upc.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.upc.entity.Cliente;
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
			Usuario usersession = usuarioService.findByUsernameAndPassword(usuario.getUsername(), usuario.getPassword());
			usuario.setNombreCompleto(usersession.getNombreCompleto());
			session.setAttribute("username", usuario.getUsername());
			session.setAttribute("nombreCompleto", usuario.getNombreCompleto());
			return "usuario_sesion";
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
	
	@RequestMapping("/index_registrar")
	public String newUsuario(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "index_registrar";
	}
	
	@RequestMapping(value = "/usuarioRegistrar", method = RequestMethod.POST)
	public String saveUsuario(Usuario usuario) {
		usuarioService.saveUsuario(usuario);
		return "redirect:/";
	}
	
	@RequestMapping("/usuario_perfiles")
	public String usuarioPerfiles(Model model) {
		Usuario usuario=new Usuario();
		model.addAttribute("usuario",usuario );
		return "usuario_perfiles";
	}
	
	@RequestMapping("/usuario_preguntas")
	public String usuarioPreguntas(Model model) {
		Usuario usuario=new Usuario();
		model.addAttribute("usuario",usuario );
		return "usuario_preguntas";
	}
	
	@RequestMapping("/usuario_configuracion")
	public String usuarioConfiguracion(Model model) {
		Usuario usuario=new Usuario();
		model.addAttribute("usuario",usuario );
		return "usuario_configuracion";
	}
	
}
