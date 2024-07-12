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

import com.linktic.reservas.entities.Servicio;
import com.linktic.reservas.service.IServicioService;
import com.linktic.reservas.utilities.ResponseService;
import com.linktic.reservas.utilities.Status;

@RestController
@RequestMapping("/api/servicios")
public class ServicioController {

	@Autowired
	private IServicioService servicioService;

	private HttpStatus statusHttp;

	@PostMapping
	public ResponseEntity<ResponseService> crearServicio(@RequestBody Servicio servicio) {
		ResponseService response = new ResponseService();
		try {
			response.setData(servicioService.crearServicio(servicio));
			response.setStatus(Status.OK);
			statusHttp = HttpStatus.OK;
		} catch (Exception e) {
			statusHttp = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setStatus(Status.FAILURE);
			response.setMessageError("Ocurrio un error al crear la reserva." + e.getMessage());
		}
		return new ResponseEntity<>(response, statusHttp);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ResponseService> modificarReserva(@PathVariable Long id, @RequestBody Servicio servicio) {
		ResponseService response = new ResponseService();

		try {
			response.setData(servicioService.modificarServicio(id, servicio));
			response.setStatus(Status.OK);
			statusHttp = HttpStatus.OK;
		} catch (Exception e) {
			statusHttp = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setStatus(Status.FAILURE);
			response.setMessageError("Ocurrio un error al modificar la reserva." + e.getMessage());
		}

		return new ResponseEntity<>(response, statusHttp);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseService> eliminarReserva(@PathVariable Long id) {
		ResponseService response = new ResponseService();

		try {
			servicioService.eliminarServicio(id);
			response.setStatus(Status.OK);
			statusHttp = HttpStatus.OK;
		} catch (Exception e) {
			statusHttp = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setStatus(Status.FAILURE);
			response.setMessageError("Ocurrio un error al eliminar la reserva." + e.getMessage());
		}

		return new ResponseEntity<>(response, statusHttp);
	}

	@GetMapping
	public ResponseEntity<ResponseService> obtenerReservas() {
		ResponseService response = new ResponseService();
		try {
			response.setData(servicioService.obtenerServicios());
			response.setStatus(Status.OK);
			statusHttp = HttpStatus.OK;
		} catch (Exception e) {
			statusHttp = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setStatus(Status.FAILURE);
			response.setMessageError("Ocurrio un error al obtener las reservas." + e.getMessage());
		}

		return new ResponseEntity<>(response, statusHttp);

	}
}
