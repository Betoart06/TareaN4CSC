package com.example.banking.dto;

import java.math.BigDecimal;

/**
 * DTO (Data Transfer Object) que contiene los datos necesarios para realizar una transferencia.
 * Se utiliza para recibir la información desde el cliente.
 */
public class TransferenciaDTO {

    private Long cuentaOrigenId;
    private Long cuentaDestinoId;
    private BigDecimal monto;

    // Constructores
    public TransferenciaDTO() {
    }

    public TransferenciaDTO(Long cuentaOrigenId, Long cuentaDestinoId, BigDecimal monto) {
        this.cuentaOrigenId = cuentaOrigenId;
        this.cuentaDestinoId = cuentaDestinoId;
        this.monto = monto;
    }

    // Getters y Setters
    public Long getCuentaOrigenId() {
        return cuentaOrigenId;
    }

    public void setCuentaOrigenId(Long cuentaOrigenId) {
        this.cuentaOrigenId = cuentaOrigenId;
    }

    public Long getCuentaDestinoId() {
        return cuentaDestinoId;
    }

    public void setCuentaDestinoId(Long cuentaDestinoId) {
        this.cuentaDestinoId = cuentaDestinoId;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }
}