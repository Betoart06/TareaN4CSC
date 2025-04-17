package com.example.banking.service;

import com.example.banking.dto.TransferenciaDTO;
import com.example.banking.model.Cuenta;
import com.example.banking.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * Implementación del servicio de transferencia.
 * Contiene la lógica para transferir dinero entre cuentas.
 */
@Service
public class TransferenciaServiceImpl implements TransferenciaService {

    private final CuentaRepository cuentaRepository;

    @Autowired
    public TransferenciaServiceImpl(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    /**
     * Realiza una transferencia entre dos cuentas.
     * Este método está anotado con @Transactional para asegurar que, en caso de error,
     * se revierten todas las operaciones realizadas dentro del método.
     */
    @Override
    @Transactional
    public boolean realizarTransferencia(TransferenciaDTO transferenciaDTO) {
        // Obtener las cuentas
        Cuenta cuentaOrigen = cuentaRepository.findById(transferenciaDTO.getCuentaOrigenId())
                .orElseThrow(() -> new RuntimeException("Cuenta origen no encontrada"));

        Cuenta cuentaDestino = cuentaRepository.findById(transferenciaDTO.getCuentaDestinoId())
                .orElseThrow(() -> new RuntimeException("Cuenta destino no encontrada"));

        // Verificar que el monto sea positivo
        if (transferenciaDTO.getMonto().compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("El monto de la transferencia debe ser positivo");
        }

        // Verificar que haya saldo suficiente
        if (cuentaOrigen.getSaldo().compareTo(transferenciaDTO.getMonto()) < 0) {
            return false; // Saldo insuficiente
        }

        // Realizar la transferencia
        cuentaOrigen.setSaldo(cuentaOrigen.getSaldo().subtract(transferenciaDTO.getMonto()));
        cuentaDestino.setSaldo(cuentaDestino.getSaldo().add(transferenciaDTO.getMonto()));

        // Guardar los cambios
        cuentaRepository.save(cuentaOrigen);
        cuentaRepository.save(cuentaDestino);

        return true;
    }
}