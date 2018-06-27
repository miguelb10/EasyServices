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
<<<<<<< HEAD
<<<<<<< HEAD

import com.upc.service.ClienteService;
import com.upc.service.EmpleadoService;
import com.upc.service.EmpresaService;
import com.upc.service.TipoEmpresaService;

=======
>>>>>>> parent of ccfd0d8... Merge branch 'Cristian'
=======
>>>>>>> parent of ccfd0d8... Merge branch 'Cristian'
import com.upc.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private CiudadService ciudadService;
<<<<<<< HEAD
<<<<<<< HEAD
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

=======
>>>>>>> parent of ccfd0d8... Merge branch 'Cristian'
=======
>>>>>>> parent of ccfd0d8... Merge branch 'Cristian'

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@ModelAttribute("usuario") Usuario usuario, HttpSession session, ModelMap modelMap) {
		if (usuarioService.findByUsernameAndPassword(usuario.getUsername(), usuario.getPassword()) != null) {
			Usuario usersession = usuarioService.findByUsernameAndPassword(usuario.getUsername(),
					usuario.getPassword());
			// usuario.setNombreCompleto(usersession.getNombreCompleto());
			session.setAttribute("usuarioSesion", usersession);
			modelMap.addAttribute("usersession", session.getAttribute("usuarioSesion"));
			// session.setAttribute("username", usuario.getUsername());
			// session.setAttribute("nombreCompleto", usuario.getNombreCompleto());
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
<<<<<<< HEAD
<<<<<<< HEAD
	public String usuarioPerfiles(Model model, HttpSession session, ModelMap modelMap) {
		TipoEmpresa compania=tipoEmpresaService.getTipoEmpresaById(1);
		TipoEmpresa independiente=tipoEmpresaService.getTipoEmpresaById(2);
		
		Cliente listacliente = clienteService.getClienteByUsuario((Usuario) session.getAttribute("usuarioSesion"));	
		Empresa listaempresacompania = empresaService.getEmpresaByUsuarioAndTipoEmpresa((Usuario) session.getAttribute("usuarioSesion"), compania);
		Empresa listaempresaindependiente = empresaService.getEmpresaByUsuarioAndTipoEmpresa((Usuario) session.getAttribute("usuarioSesion"), independiente);
		Empleado listaempleado=empleadoService.getEmpresaByUsuario((Usuario) session.getAttribute("usuarioSesion"));
		Administrador listaadministrador=administradorService.getEmpresaByUsuario((Usuario) session.getAttribute("usuarioSesion"));
		model.addAttribute("listaclientes", listacliente);
		model.addAttribute("listaempresacompanias", listaempresacompania);
		model.addAttribute("listaempresaindependientes", listaempresaindependiente);
		model.addAttribute("listaempleados", listaempleado);
		model.addAttribute("listaadministradores", listaadministrador);
=======
	public String usuarioPerfiles(Model model, HttpSession session, ModelMap modelMap) {		
>>>>>>> parent of ccfd0d8... Merge branch 'Cristian'
=======
	public String usuarioPerfiles(Model model, HttpSession session, ModelMap modelMap) {		
>>>>>>> parent of ccfd0d8... Merge branch 'Cristian'
		modelMap.addAttribute("usersession", session.getAttribute("usuarioSesion"));
		return "usuario_perfiles";
	}

	@RequestMapping("/usuario_preguntas")
	public String usuarioPreguntas(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		return "usuario_preguntas";
	}

<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> parent of ccfd0d8... Merge branch 'Cristian'
	@RequestMapping("/usuario_configuracion")
	public String usuarioConfiguracion(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		return "usuario_configuracion";
	}

<<<<<<< HEAD
>>>>>>> parent of ccfd0d8... Merge branch 'Cristian'
=======
>>>>>>> parent of ccfd0d8... Merge branch 'Cristian'
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
