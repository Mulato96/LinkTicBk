package com.linktic.reservas.service;

import java.util.List;

import com.linktic.reservas.entities.Cliente;

public interface IClienteService {

	Cliente crearCliente(Cliente cliente);

	Cliente modificarCliente(Long id, Cliente cliente);

	void eliminarCliente(Long id);

	List<Cliente> obtenerClientes();
}
