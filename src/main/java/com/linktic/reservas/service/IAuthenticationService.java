package com.linktic.reservas.service;

import com.linktic.reservas.dao.request.SignUpRequest;
import com.linktic.reservas.dao.request.SigninRequest;
import com.linktic.reservas.dao.response.JwtAuthenticationResponse;

public interface IAuthenticationService {
	JwtAuthenticationResponse signup(SignUpRequest request);

	JwtAuthenticationResponse signin(SigninRequest request);
}
