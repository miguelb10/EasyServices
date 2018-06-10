package com.upc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.entity.Administrador;
import com.upc.entity.Cliente;
import com.upc.entity.Usuario;
import com.upc.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService{

	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public Iterable<Cliente> listAllCliente() {
		// TODO Auto-generated method stub
		return clienteRepository.findAll();
	}

	@Override
	public Cliente getClienteById(Integer id) {
		// TODO Auto-generated method stub
		return clienteRepository.findOne(id);
	}

	@Override
	public Cliente saveCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return clienteRepository.save(cliente);
	}

	@Override
	public void deleteCliente(Integer id) {
		// TODO Auto-generated method stub
		clienteRepository.delete(id);
	}

	@Override
	public Iterable<Cliente> getEmpresaByUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return clienteRepository.findByUsuario(usuario);
	}

}
