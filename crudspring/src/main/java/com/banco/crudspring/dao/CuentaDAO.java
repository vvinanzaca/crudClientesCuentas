package com.banco.crudspring.dao;

import com.banco.crudspring.modelos.CuentaDTO;

import java.util.List;

public interface CuentaDAO {

    CuentaDTO guardarCuenta(CuentaDTO cuentaDTO);

    CuentaDTO buscarCuentaPk(CuentaDTO cuentaDTO);

    List<CuentaDTO> buscarCuentaCliente(Integer ccliente);
}
