package com.linktic.reservas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.linktic.reservas.entities.Cliente;

public interface IUserRepository extends JpaRepository<Cliente, Long> {
	Optional<Cliente> findByEmail(String email);
}