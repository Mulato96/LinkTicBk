package com.linktic.reservas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.linktic.reservas.entities.Servicio;

public interface IServicioRepository extends JpaRepository<Servicio, Long> {
	List<Servicio> findByNombre(String nombre);
}