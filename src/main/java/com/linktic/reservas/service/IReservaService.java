package com.linktic.reservas.service;

import java.util.Date;
import java.util.List;

import com.linktic.reservas.entities.Reserva;

public interface IReservaService {

	Reserva crearReserva(Long clienteId, Long servicioId, Reserva reservaDetalles);

	Reserva modificarReserva(Long id, Long clienteId, Long servicioId, Reserva reservaDetalles);

	void eliminarReserva(Long id);

	List<Reserva> obtenerReservas();

	List<Reserva> filtrarReservasPorFecha(Date fecha);

	List<Reserva> filtrarReservasPorCliente(Long clienteId);

	List<Reserva> filtrarReservasPorServicio(Long servicioId);
}
