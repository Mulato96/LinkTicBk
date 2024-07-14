package com.linktic.reservas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.linktic.reservas.entities.Cliente;

public interface IClienteRepository extends JpaRepository<Cliente, Long> {	
}
