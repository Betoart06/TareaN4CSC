package com.example.banking.controller;

import com.example.banking.dto.TransferenciaDTO;
import com.example.banking.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador REST que expone los endpoints para realizar transferencias.
 */
@RestController
@RequestMapping("/api/transferencias")
public class TransferenciaController {

    private final TransferenciaService transferenciaService;

    @Autowired
    public TransferenciaController(TransferenciaService transferenciaService) {
        this.transferenciaService = transferenciaService;
    }

    /**
     * Endpoint para realizar una transferencia mediante una petición POST.
     *
     * @param transferenciaDTO Datos de la transferencia en formato JSON
     * @return ResponseEntity con el estado HTTP correspondiente:
     *         - 200 OK si la transferencia fue exitosa
     *         - 400 BAD_REQUEST si no hay saldo suficiente
     *         - 404 NOT_FOUND si alguna de las cuentas no existe
     *         - 500 INTERNAL_SERVER_ERROR para otros errores
     */
    @PostMapping
    public ResponseEntity<String> realizarTransferencia(@RequestBody TransferenciaDTO transferenciaDTO) {
        try {
            boolean resultado = transferenciaService.realizarTransferencia(transferenciaDTO);
            if (resultado) {
                return ResponseEntity.ok("Transferencia realizada con éxito");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Saldo insuficiente");
            }
        } catch (RuntimeException e) {
            if (e.getMessage().contains("no encontrada")) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al procesar la transferencia: " + e.getMessage());
        }
    }
}