package com.example.banking.service;

import com.example.banking.dto.TransferenciaDTO;

/**
 * Interfaz que define el servicio de transferencia.
 */
public interface TransferenciaService {

    /**
     * Realiza una transferencia entre dos cuentas.
     *
     * @param transferenciaDTO DTO con los datos de la transferencia
     * @return true si la transferencia se realizó con éxito, false si hubo algún problema (ej. saldo insuficiente)
     * @throws RuntimeException si alguna de las cuentas no existe
     */
    boolean realizarTransferencia(TransferenciaDTO transferenciaDTO);
}