package com.example.banking;

import com.example.banking.model.Cuenta;
import com.example.banking.repository.CuentaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class BankingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankingApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(CuentaRepository cuentaRepository) {
        return args -> {
            // Crear algunas cuentas de ejemplo
            cuentaRepository.save(new Cuenta("Alberto Fernández", new BigDecimal("8500.00")));
            cuentaRepository.save(new Cuenta("Rosa Morales", new BigDecimal("4750.25")));
            cuentaRepository.save(new Cuenta("Carlos Mendoza", new BigDecimal("3200.75")));
            cuentaRepository.save(new Cuenta("Lucía Ramírez", new BigDecimal("6850.50")));
        };
    }
}