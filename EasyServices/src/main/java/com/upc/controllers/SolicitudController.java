package com.upc.controllers;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.upc.entity.Cliente;
import com.upc.entity.Solicitud;
import com.upc.entity.Usuario;
import com.upc.service.ClienteService;
import com.upc.service.SolicitudService;

@Controller
public class SolicitudController {
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private SolicitudService solicitudService;

	@RequestMapping(value = "/solicitud/new/{idservicio}", method = RequestMethod.GET)
	public String newSolicitud(@PathVariable Integer idservicio, Model model) {

		Solicitud solicitud = new Solicitud();
		model.addAttribute("idservicio", idservicio);
		model.addAttribute("solicitud", solicitud);
		return "newsolicitud";
	}

	@RequestMapping(value = "/solicitudSave", method = RequestMethod.POST)
	public String saveSolicitud(@ModelAttribute("solicitud") Solicitud solicitud, Model model, HttpSession session,
			ModelMap modelMap) {
		try {
			Usuario usuario = (Usuario) session.getAttribute("usuarioSesion");
			Cliente cliente = new Cliente();
			cliente = clienteService.getClienteByUsuario(usuario);
			solicitud.setCliente(cliente);
			model.addAttribute("confirmacion", "Su solicitud se registro correctamente");
			solicitudService.saveSolicitud(solicitud);
			modelMap.addAttribute("usersession", session.getAttribute("usuarioSesion"));
			return "cliente_principal";
		} catch (Exception e) {
			model.addAttribute("confirmacion", "Error en registrar la solicitud");
			modelMap.addAttribute("usersession", session.getAttribute("usuarioSesion"));
			return "cliente_principal";
		}
	}

}
