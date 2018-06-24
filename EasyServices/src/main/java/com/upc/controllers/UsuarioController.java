package com.upc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.upc.entity.Administrador;
import com.upc.entity.Cliente;
import com.upc.entity.Empleado;
import com.upc.entity.Empresa;
import com.upc.entity.TipoEmpresa;
import com.upc.entity.Usuario;
import com.upc.service.AdministradorService;
import com.upc.service.CiudadService;
import com.upc.service.ClienteService;
import com.upc.service.EmpleadoService;
import com.upc.service.EmpresaService;
import com.upc.service.TipoEmpresaService;
import com.upc.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private CiudadService ciudadService;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private EmpresaService empresaService;
	@Autowired
	private TipoEmpresaService tipoEmpresaService;
	@Autowired
	private EmpleadoService empleadoService;
	@Autowired
	private AdministradorService administradorService;

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@ModelAttribute("usuario") Usuario usuario, HttpSession session, ModelMap modelMap) {
		if (usuarioService.findByUsernameAndPassword(usuario.getUsername(), usuario.getPassword()) != null) {
			Usuario usersession = usuarioService.findByUsernameAndPassword(usuario.getUsername(),
					usuario.getPassword());
			session.setAttribute("usuarioSesion", usersession);
			modelMap.addAttribute("usersession", session.getAttribute("usuarioSesion"));
			return "usuario_sesion";
		} else {
			modelMap.put("error", "Usuario invalido");
			return "index";
		}
	}
	
	@RequestMapping(value = "EliminarSesion", method = RequestMethod.POST)
	public String cerrarLogin(HttpSession session, ModelMap modelMap) {
		modelMap.put("mostrar", "Cerro Sesion");
		return "index";
	}
	

	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("usuarios", usuarioService.listAllUsuario());
		return "usuarios";
	}
	
	@RequestMapping(value = "/usuario/configuracion", method = RequestMethod.GET)
	public String actualizarUsuario(Model model,HttpSession session, ModelMap modelMap) {
		modelMap.addAttribute("usuario", session.getAttribute("usuarioSesion"));
		return "usuario_configuracion";
	}
	
	@RequestMapping(value = "/usuario", method = RequestMethod.POST)
	public String saveEntidad(Usuario usuario) {
		usuarioService.saveUsuario(usuario);
		return "redirect:/usuario_sesion";
	}

	@RequestMapping("/index_registrar")
	public String newUsuario(Model model) {
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("ciudades", ciudadService.listAllCiudad());
		return "index_registrar";
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
		TipoEmpresa compania=tipoEmpresaService.getTipoEmpresaById(1);
		TipoEmpresa independiente=tipoEmpresaService.getTipoEmpresaById(2);
		
		Iterable<Cliente> listacliente = clienteService.getClienteByUsuario((Usuario) session.getAttribute("usuarioSesion"));	
		Iterable<Empresa> listaempresacompania = empresaService.getEmpresaByUsuarioAndTipoEmpresa((Usuario) session.getAttribute("usuarioSesion"), compania);
		Iterable<Empresa> listaempresaindependiente = empresaService.getEmpresaByUsuarioAndTipoEmpresa((Usuario) session.getAttribute("usuarioSesion"), independiente);
		Iterable<Empleado> listaempleado=empleadoService.getEmpresaByUsuario((Usuario) session.getAttribute("usuarioSesion"));
		Iterable<Administrador> listaadministrador=administradorService.getEmpresaByUsuario((Usuario) session.getAttribute("usuarioSesion"));
		model.addAttribute("listaclientes", listacliente);
		model.addAttribute("listaempresacompanias", listaempresacompania);
		model.addAttribute("listaempresaindependientes", listaempresaindependiente);
		model.addAttribute("listaempleados", listaempleado);
		model.addAttribute("listaadministradores", listaadministrador);
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

}
