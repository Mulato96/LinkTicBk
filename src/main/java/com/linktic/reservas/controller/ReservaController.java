package com.linktic.reservas.controller;

import java.util.Date;

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

import com.linktic.reservas.dto.ReservaDTO;
import com.linktic.reservas.service.IReservaService;
import com.linktic.reservas.utilities.ResponseService;
import com.linktic.reservas.utilities.Status;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

	@Autowired
	private IReservaService reservaService;

	private HttpStatus statusHttp;

	@PostMapping
	public ResponseEntity<ResponseService> crearReserva(@RequestBody ReservaDTO reservaDTO) {
		ResponseService response = new ResponseService();
		try {
			response.setData(reservaService.crearReserva(reservaDTO));
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
	public ResponseEntity<ResponseService> modificarReserva(@PathVariable Long id, ReservaDTO reservaDTO) {
		ResponseService response = new ResponseService();

		try {
			response.setData(reservaService.modificarReserva(id, reservaDTO));
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
			reservaService.eliminarReserva(id);
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
			response.setData(reservaService.obtenerReservas());
			response.setStatus(Status.OK);
			statusHttp = HttpStatus.OK;
		} catch (Exception e) {
			statusHttp = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setStatus(Status.FAILURE);
			response.setMessageError("Ocurrio un error al obtener las reservas." + e.getMessage());
		}

		return new ResponseEntity<>(response, statusHttp);

	}

	@GetMapping("/fecha/{fecha}")
	public ResponseEntity<ResponseService> filtrarReservasPorFecha(@PathVariable Date fecha) {
		ResponseService response = new ResponseService();
		try {
			response.setData(reservaService.filtrarReservasPorFecha(fecha));
			response.setStatus(Status.OK);
			statusHttp = HttpStatus.OK;
		} catch (Exception e) {
			statusHttp = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setStatus(Status.FAILURE);
			response.setMessageError("Ocurrio un error al consultar." + e.getMessage());
		}

		return new ResponseEntity<>(response, statusHttp);
	}

	@GetMapping("/cliente/{clienteId}")
	public ResponseEntity<ResponseService> filtrarReservasPorCliente(@PathVariable Long clienteId) {
		ResponseService response = new ResponseService();
		try {
			response.setData(reservaService.filtrarReservasPorCliente(clienteId));
			response.setStatus(Status.OK);
			statusHttp = HttpStatus.OK;
		} catch (Exception e) {
			statusHttp = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setStatus(Status.FAILURE);
			response.setMessageError("Ocurrio un error al consultar." + e.getMessage());
		}

		return new ResponseEntity<>(response, statusHttp);
	}

	@GetMapping("/servicio/{servicioId}")
	public ResponseEntity<ResponseService> filtrarReservasPorServicio(@PathVariable Long servicioId) {
		ResponseService response = new ResponseService();
		try {
			response.setData(reservaService.filtrarReservasPorServicio(servicioId));
			response.setStatus(Status.OK);
			statusHttp = HttpStatus.OK;
		} catch (Exception e) {
			statusHttp = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setStatus(Status.FAILURE);
			response.setMessageError("Ocurrio un error al consultar." + e.getMessage());
		}

		return new ResponseEntity<>(response, statusHttp);
	}
}
