package com.linktic.reservas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.linktic.reservas.dao.request.SignUpRequest;
import com.linktic.reservas.dao.request.SigninRequest;
import com.linktic.reservas.dao.response.JwtAuthenticationResponse;
import com.linktic.reservas.service.IAuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
	@Autowired
	IAuthenticationService authenticationService;

	@PostMapping("/registro")
	public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SignUpRequest request) {
		return ResponseEntity.ok(authenticationService.signup(request));
	}

	@PostMapping("/login")
	public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest request) {
		return ResponseEntity.ok(authenticationService.signin(request));
	}

}
