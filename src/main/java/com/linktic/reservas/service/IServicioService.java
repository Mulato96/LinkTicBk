package com.linktic.reservas.service;

import java.util.List;

import com.linktic.reservas.entities.Servicio;

public interface IServicioService {

	Servicio crearServicio(Servicio servicio);

	Servicio modificarServicio(Long id, Servicio servicio);

	void eliminarServicio(Long id);

	List<Servicio> obtenerServicios();
}
