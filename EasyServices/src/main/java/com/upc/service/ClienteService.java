package com.upc.service;

import com.upc.entity.Administrador;
import com.upc.entity.Cliente;
import com.upc.entity.Usuario;

public interface ClienteService {
	Iterable<Cliente> listAllCliente();
	Cliente getClienteById(Integer id);
	Cliente saveCliente(Cliente cliente);
	void deleteCliente(Integer id);

	Iterable<Cliente> getEmpresaByUsuario(Usuario usuario);
}
