package com.linktic.reservas.dto;

import java.util.Date;

import com.linktic.reservas.entities.Cliente;
import com.linktic.reservas.entities.Servicio;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservaDTO {

	private Long id;
	private Date fecha;
	private String detalles;
	private Cliente cliente;
	private Servicio servicio;
	private boolean clientnew;
}
