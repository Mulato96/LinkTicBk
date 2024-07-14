package com.linktic.reservas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linktic.reservas.entities.Servicio;
import com.linktic.reservas.repository.IServicioRepository;
import com.linktic.reservas.service.IServicioService;
import com.linktic.reservas.utilities.ResourceNotFoundException;

@Service
public class ServicioServiceImpl implements IServicioService {

	@Autowired
	private IServicioRepository servicioRepository;

	public Servicio crearServicio(Servicio servicio) {
		Servicio servicioReturn = new Servicio();

		servicioReturn.setDescripcion(servicio.getDescripcion());
		servicioReturn.setNombre(servicio.getNombre());
		servicioReturn.setPrecio(servicio.getPrecio());

		return servicioRepository.save(servicioReturn);
	}

	public Servicio modificarServicio(Long id, Servicio servicio) {

		Servicio servicioReturn = servicioRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Servicio no encontrado"));

		servicioReturn.setDescripcion(servicio.getDescripcion());
		servicioReturn.setNombre(servicio.getNombre());
		servicioReturn.setPrecio(servicio.getPrecio());

		return servicioRepository.save(servicioReturn);
	}

	public void eliminarServicio(Long id) {
		Servicio reserva = servicioRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Servicio no encontrada"));
		servicioRepository.delete(reserva);
	}

	public List<Servicio> obtenerServicios() {
		return servicioRepository.findAll();
	}

}
