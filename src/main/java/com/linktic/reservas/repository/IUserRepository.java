package com.linktic.reservas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.linktic.reservas.entities.Usuario;

public interface IUserRepository extends JpaRepository<Usuario, Long> {
	Optional<Usuario> findByEmail(String email);
}