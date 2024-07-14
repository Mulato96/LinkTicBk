package com.linktic.reservas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.linktic.reservas.entities.Cliente;
import com.linktic.reservas.service.IClienteService;
import com.linktic.reservas.utilities.ResponseService;
import com.linktic.reservas.utilities.Status;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

	@Autowired
	private IClienteService clienteService;

	private HttpStatus statusHttp;

	@PostMapping
	public ResponseEntity<ResponseService> crearCliente(@RequestBody Cliente cliente) {
		ResponseService response = new ResponseService();
		try {
			response.setData(clienteService.crearCliente(cliente));
			response.setStatus(Status.OK);
			statusHttp = HttpStatus.OK;
		} catch (Exception e) {
			statusHttp = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setStatus(Status.FAILURE);
			response.setMessageError("Ocurrio un error al crear el cliente." + e.getMessage());
		}
		return new ResponseEntity<>(response, statusHttp);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ResponseService> modificarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
		ResponseService response = new ResponseService();

		try {
			response.setData(clienteService.modificarCliente(id, cliente));
			response.setStatus(Status.OK);
			statusHttp = HttpStatus.OK;
		} catch (Exception e) {
			statusHttp = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setStatus(Status.FAILURE);
			response.setMessageError("Ocurrio un error al modificar el cliente." + e.getMessage());
		}

		return new ResponseEntity<>(response, statusHttp);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseService> eliminarServicio(@PathVariable Long id) {
		ResponseService response = new ResponseService();

		try {
			clienteService.eliminarCliente(id);
			response.setStatus(Status.OK);
			statusHttp = HttpStatus.OK;
		} catch (Exception e) {
			statusHttp = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setStatus(Status.FAILURE);
			response.setMessageError("Ocurrio un error al eliminar el cliente." + e.getMessage());
		}

		return new ResponseEntity<>(response, statusHttp);
	}

	@GetMapping
	public ResponseEntity<ResponseService> obtenerClientes() {
		ResponseService response = new ResponseService();
		try {
			response.setData(clienteService.obtenerClientes());
			response.setStatus(Status.OK);
			statusHttp = HttpStatus.OK;
		} catch (Exception e) {
			statusHttp = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setStatus(Status.FAILURE);
			response.setMessageError("Ocurrio un error al obtener los clientes." + e.getMessage());
		}

		return new ResponseEntity<>(response, statusHttp);

	}

}
