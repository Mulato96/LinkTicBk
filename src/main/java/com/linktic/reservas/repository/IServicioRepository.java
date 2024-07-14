package com.linktic.reservas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.linktic.reservas.entities.Servicio;

public interface IServicioRepository extends JpaRepository<Servicio, Long> {
}