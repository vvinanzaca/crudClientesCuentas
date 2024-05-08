package com.banco.crudspring.service.impl;

import com.banco.crudspring.dao.CuentaDAO;
import com.banco.crudspring.entities.Cuenta;
import com.banco.crudspring.modelos.CuentaDTO;
import com.banco.crudspring.service.CuentaService;
import com.banco.crudspring.util.ApplicationDates;
import com.banco.crudspring.util.EntitiesCast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CuentaServiceImpl implements CuentaService {

    @Autowired
    private CuentaDAO cuentaDAO;
    @Override
    public CuentaDTO guardarCuenta(CuentaDTO cuentaDTO) {
        cuentaDTO.setFhasta(ApplicationDates.DEFAULT_EXPIRY_TIMESTAMP);
        cuentaDTO.setFcreacion(ApplicationDates.getDBTimestamp());
        cuentaDTO.setFmodificacion(ApplicationDates.getDBTimestamp());
        return cuentaDAO.guardarCuenta(cuentaDTO);
    }

    @Override
    public CuentaDTO modificarCuenta(String ccuenta, BigDecimal saldo) {
        CuentaDTO cuentaDTO = cuentaDAO.buscarCuentaPk(CuentaDTO.builder().ccuenta(ccuenta).fhasta(ApplicationDates.DEFAULT_EXPIRY_TIMESTAMP).build());
        return updateCuenta(cuentaDTO, saldo);
    }

    public CuentaDTO updateCuenta(CuentaDTO cuentaUpdate, BigDecimal saldo) {
        caducarCuenta(cuentaUpdate.getCcuenta());
        cuentaUpdate.setFmodificacion(ApplicationDates.getDBTimestamp());
        cuentaUpdate.setSaldo(saldo);
        return cuentaDAO.guardarCuenta(cuentaUpdate);
    }

    public void caducarCuenta(String ccuenta) {
        CuentaDTO cuentaDTOAnt = cuentaDAO.buscarCuentaPk(CuentaDTO.builder().ccuenta(ccuenta).fhasta(ApplicationDates.DEFAULT_EXPIRY_TIMESTAMP).build());
        cuentaDTOAnt.setFhasta(ApplicationDates.getDBTimestamp());
        cuentaDAO.guardarCuenta(cuentaDTOAnt);
    }

}
