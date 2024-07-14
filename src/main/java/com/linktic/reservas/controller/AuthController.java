package com.linktic.reservas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.linktic.reservas.dao.request.SignUpRequest;
import com.linktic.reservas.dao.request.SigninRequest;
import com.linktic.reservas.dao.response.JwtAuthenticationResponse;
import com.linktic.reservas.service.IAuthenticationService;
import com.linktic.reservas.utilities.ResponseService;
import com.linktic.reservas.utilities.Status;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
	@Autowired
	IAuthenticationService authenticationService;

	private HttpStatus statusHttp;

	@PostMapping("/registro")
	public ResponseEntity<ResponseService> signup(@RequestBody SignUpRequest request) {
		ResponseService response = new ResponseService();

		try {
			response.setData(authenticationService.signup(request));
			response.setStatus(Status.OK);
			statusHttp = HttpStatus.OK;
		} catch (Exception e) {
			statusHttp = HttpStatus.INTERNAL_SERVER_ERROR;
			response.setStatus(Status.FAILURE);
			response.setMessageError("Ocurrio un error al crear la reserva." + e.getCause());
		}
		return new ResponseEntity<>(response, statusHttp);
	
	}

	@PostMapping("/login")
	public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest request) {
		return ResponseEntity.ok(authenticationService.signin(request));
	}

}
