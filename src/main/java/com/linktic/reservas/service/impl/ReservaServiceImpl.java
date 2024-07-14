package com.linktic.reservas.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linktic.reservas.dto.ReservaDTO;
import com.linktic.reservas.entities.Cliente;
import com.linktic.reservas.entities.Reserva;
import com.linktic.reservas.entities.Servicio;
import com.linktic.reservas.repository.IClienteRepository;
import com.linktic.reservas.repository.IReservaRepository;
import com.linktic.reservas.repository.IServicioRepository;
import com.linktic.reservas.service.IReservaService;
import com.linktic.reservas.utilities.ResourceNotFoundException;

@Service
public class ReservaServiceImpl implements IReservaService {

	@Autowired
	private IReservaRepository reservaRepository;
	@Autowired
	private IClienteRepository clienteRepository;
	@Autowired
	private IServicioRepository servicioRepository;

	public Reserva crearReserva(ReservaDTO reservaDTO) {
		Reserva reserva = new Reserva();
		Cliente cliente = new Cliente();

		if (reservaDTO.isClientnew()) {
			cliente.setNombre(reservaDTO.getCliente().getNombre());
			cliente.setApellido(reservaDTO.getCliente().getApellido());
			cliente.setTelefono(reservaDTO.getCliente().getTelefono());
			cliente.setEmail(reservaDTO.getCliente().getEmail());
			cliente = clienteRepository.save(cliente);
		} else {
			cliente = reservaDTO.getCliente();
		}

		reserva.setCliente(cliente);
		reserva.setServicio(reservaDTO.getServicio());
		reserva.setFecha(reservaDTO.getFecha());
		reserva.setDetalles(reservaDTO.getDetalles());

		return reservaRepository.save(reserva);
	}

	public Reserva modificarReserva(Long id, ReservaDTO reservaDTO) {
		Reserva reserva = reservaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Reserva no encontrada"));
		
		reserva.setCliente(reservaDTO.getCliente());
		reserva.setServicio(reservaDTO.getServicio());
		reserva.setFecha(reservaDTO.getFecha());
		reserva.setDetalles(reservaDTO.getDetalles());

		return reservaRepository.save(reserva);
	}

	public void eliminarReserva(Long id) {
		Reserva reserva = reservaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Reserva no encontrada"));
		reservaRepository.delete(reserva);
	}

	public List<Reserva> obtenerReservas() {
		return reservaRepository.findAll();
	}

	public List<Reserva> filtrarReservasPorFecha(Date fecha) {
		return reservaRepository.findByFecha(fecha);
	}

	public List<Reserva> filtrarReservasPorCliente(Long clienteId) {
		Cliente cliente = clienteRepository.findById(clienteId)
				.orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));
		return reservaRepository.findByCliente(cliente);
	}

	public List<Reserva> filtrarReservasPorServicio(Long servicioId) {
		Servicio servicio = servicioRepository.findById(servicioId)
				.orElseThrow(() -> new ResourceNotFoundException("Servicio no encontrado"));
		return reservaRepository.findByServicio(servicio);
	}
}
