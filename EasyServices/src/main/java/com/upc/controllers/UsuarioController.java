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

import com.upc.entity.ClassM;
import com.upc.entity.Cliente;
import com.upc.entity.Empleado;
import com.upc.entity.Empresa;
import com.upc.entity.Usuario;
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
	private EmpleadoService empleadoService;
	@Autowired
	private EmpresaService empresaService;
	@Autowired
	private TipoEmpresaService tipoEmpresaService;

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(Model model,@ModelAttribute("usuario") Usuario usuario, HttpSession session, ModelMap modelMap) {
		if (usuarioService.findByUsernameAndPassword(usuario.getUsername(), usuario.getPassword()) != null) {
			Usuario usersession = usuarioService.findByUsernameAndPassword(usuario.getUsername(),
					usuario.getPassword());
			session.setAttribute("usuarioSesion", usersession);
			modelMap.addAttribute("usersession", session.getAttribute("usuarioSesion"));
			
			List<ClassM> listPerfiles = new ArrayList<ClassM>();
			listPerfiles=findPerfiles(usersession);
			
			
			model.addAttribute("useraux", listPerfiles);
			
			
			return "usuario_perfiles";
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
	
	public List<ClassM> findPerfiles(Usuario usuario){
		List<ClassM> listPerfiles = new ArrayList<ClassM>();
		ClassM perfCli = new ClassM();
		ClassM perfEmpl = new ClassM();
		ClassM perfEmprComp = new ClassM();
		ClassM perfEmprIndp = new ClassM();
		Cliente cliente = null;
		Empleado empleado = null;
		Empresa empresaComp = null;
		Empresa empresaIndp = null;		
		
		cliente = clienteService.getClienteByUsuario(usuario);
		if (cliente != null) {
			perfCli.setNomPerfil("Cliente");
			perfCli.setRecurso("../img/cliente.jpg");
			perfCli.setAccion("/indexCliente");
			
			listPerfiles.add(perfCli);
		}
		empleado = empleadoService.getEmpleadoByUsuario(usuario);
		if (empleado != null) {
			perfEmpl.setNomPerfil("Empleado");
			perfEmpl.setRecurso("../img/empleado.jpg");
			perfEmpl.setAccion("/empleadoPerfil");
			
			listPerfiles.add(perfEmpl);
		}
		empresaComp = empresaService.getEmpresaByUsuarioAndTipoEmpresa(usuario, tipoEmpresaService.getTipoEmpresaById(1));
		if (empresaComp != null) {
			perfEmprComp.setNomPerfil("Compañia");
			perfEmprComp.setRecurso("../img/empresa.png");
			perfEmprComp.setAccion("/EmpresaCompaniaPerfil");
			
			listPerfiles.add(perfEmprComp);
		}
		
		empresaIndp = empresaService.getEmpresaByUsuarioAndTipoEmpresa(usuario, tipoEmpresaService.getTipoEmpresaById(2));
		if (empresaIndp != null) {
			perfEmprIndp.setNomPerfil("Independiente");
			perfEmprIndp.setRecurso("../img/independiente.png");
			perfEmprIndp.setAccion("/EmpresaIndependientePerfil");
			
			listPerfiles.add(perfEmprIndp);
		}
				
		return listPerfiles;
	}

}
