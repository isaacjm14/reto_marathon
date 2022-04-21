package com.marathon.reto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marathon.reto.model.entity.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
