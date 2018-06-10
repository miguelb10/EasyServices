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
			Usuario usersession = usuarioService.findByUsernameAndPassword(usuario.getUsername(), usuario.getPassword());
			usuario.setNombre_completo(usersession.getNombre_completo());
			session.setAttribute("username", usuario.getUsername());
			session.setAttribute("nombre_completo", usuario.getNombre_completo());
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
	public String indexRegistrar(Model model) {
		Usuario usuario=new Usuario();
		model.addAttribute("usuario",usuario );
		return "index_registrar";
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
