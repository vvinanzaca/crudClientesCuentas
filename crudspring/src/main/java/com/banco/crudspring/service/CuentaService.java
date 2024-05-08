package com.banco.crudspring.service;

import com.banco.crudspring.modelos.CuentaDTO;

import java.math.BigDecimal;

public interface CuentaService {

    CuentaDTO guardarCuenta(CuentaDTO cuentaDTO);

    CuentaDTO modificarCuenta(String ccuenta, BigDecimal saldo);
}
