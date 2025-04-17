package com.example.banking.repository;

import com.example.banking.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la entidad Cuenta.
 * Proporciona operaciones básicas de persistencia para cuentas bancarias.
 */
@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
    // Spring Data JPA proporcionará automáticamente las implementaciones
    // de los métodos básicos como findById, save, delete, etc.
}