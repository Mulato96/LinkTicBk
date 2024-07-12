package com.linktic.reservas.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.linktic.reservas.entities.Cliente;
import com.linktic.reservas.entities.Reserva;
import com.linktic.reservas.entities.Servicio;

public interface IReservaRepository extends JpaRepository<Reserva, Long> {

	List<Reserva> findByFecha(Date fecha);

	List<Reserva> findByCliente(Cliente cliente);

	List<Reserva> findByServicio(Servicio servicio);
}