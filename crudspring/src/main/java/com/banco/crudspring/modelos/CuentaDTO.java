package com.banco.crudspring.modelos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CuentaDTO {

    private String ccuenta;
    private Timestamp fhasta;
    private BigDecimal saldo;
    private Timestamp fmodificacion;
    private Timestamp fcreacion;
    private String tipocuenta;
    private ClienteDTO clienteDTO;

}
