package com.upc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.upc.entity.ClassM;
import com.upc.entity.Cliente;
import com.upc.entity.Empleado;
import com.upc.entity.Empresa;
import com.upc.entity.Usuario;
import com.upc.service.ClienteService;
import com.upc.service.EmpleadoService;
import com.upc.service.EmpresaService;
import com.upc.service.TipoEmpresaService;

@Controller
public class IndexController {

	@Autowired
	private ClienteService clienteService;
	@Autowired
	private EmpleadoService empleadoService;
	@Autowired
	private EmpresaService empresaService;
	@Autowired
	private TipoEmpresaService tipoEmpresaService;
	
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
			List<ClassM> listPerfiles = new ArrayList<ClassM>();
			listPerfiles=findPerfiles((Usuario)session.getAttribute("usuarioSesion"));		
			model.addAttribute("useraux", listPerfiles);		
			return  "/usuario_perfiles";
		}
		else {
			Usuario usuario=new Usuario();
			model.addAttribute("usuario",usuario );
			return "index";			
		}
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