package com.linktic.reservas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linktic.reservas.entities.Cliente;
import com.linktic.reservas.repository.IClienteRepository;
import com.linktic.reservas.service.IClienteService;
import com.linktic.reservas.utilities.ResourceNotFoundException;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteRepository clienteRepository;

	public Cliente crearCliente(Cliente cliente) {
		Cliente clienteReturn = new Cliente();

		clienteReturn.setApellido(cliente.getApellido());
		clienteReturn.setNombre(cliente.getNombre());
		clienteReturn.setEmail(cliente.getEmail());
		clienteReturn.setTelefono(cliente.getTelefono());

		return clienteRepository.save(clienteReturn);
	}

	public Cliente modificarCliente(Long id, Cliente cliente) {

		Cliente clienteReturn = clienteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));

		clienteReturn.setApellido(cliente.getApellido());
		clienteReturn.setNombre(cliente.getNombre());
		clienteReturn.setEmail(cliente.getEmail());
		clienteReturn.setTelefono(cliente.getTelefono());

		return clienteRepository.save(clienteReturn);
	}

	public void eliminarCliente(Long id) {
		Cliente cliente = clienteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));
		clienteRepository.delete(cliente);
	}

	public List<Cliente> obtenerClientes() {
		return clienteRepository.findAll();
	}

}
