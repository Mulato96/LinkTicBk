package com.linktic.reservas.dao.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {

	private String nombre;
	private String apellido;
	private String telefono;
	private String email;
	private String password;
}