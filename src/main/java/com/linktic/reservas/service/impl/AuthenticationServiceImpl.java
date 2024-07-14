package com.linktic.reservas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.linktic.reservas.dao.request.SignUpRequest;
import com.linktic.reservas.dao.request.SigninRequest;
import com.linktic.reservas.dao.response.JwtAuthenticationResponse;
import com.linktic.reservas.entities.Role;
import com.linktic.reservas.entities.Usuario;
import com.linktic.reservas.repository.IUserRepository;
import com.linktic.reservas.service.IAuthenticationService;
import com.linktic.reservas.service.IJwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements IAuthenticationService {

	@Autowired
	IUserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	IJwtService jwtService;

	@Autowired
	AuthenticationManager authenticationManager;

	@Override
	public JwtAuthenticationResponse signup(SignUpRequest request) {
		var user = Usuario.builder().nombre(request.getNombre()).email(request.getEmail())
				.password(passwordEncoder.encode(request.getPassword())).role(Role.USER).build();
		userRepository.save(user);
		var jwt = jwtService.generateToken(user);
		return JwtAuthenticationResponse.builder().token(jwt).build();
	}

	@Override
	public JwtAuthenticationResponse signin(SigninRequest request) {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
		var user = userRepository.findByEmail(request.getEmail())
				.orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
		var jwt = jwtService.generateToken(user);
		return JwtAuthenticationResponse.builder().token(jwt).build();
	}

}
