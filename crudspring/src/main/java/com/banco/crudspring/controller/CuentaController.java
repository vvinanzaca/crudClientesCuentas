package com.banco.crudspring.controller;

import com.banco.crudspring.modelos.CuentaDTO;
import com.banco.crudspring.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/cuentas/")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    @PostMapping("/guardarCuenta")
    public ResponseEntity<CuentaDTO> saveCuenta(@RequestBody CuentaDTO cuentaDTO) {
        return  new ResponseEntity<>(cuentaService.guardarCuenta(cuentaDTO), HttpStatus.CREATED);
    }

    @PutMapping("/modificarCuenta/{ccuenta}/{saldo}")
    public ResponseEntity<CuentaDTO> modificarCuenta(@PathVariable(value = "ccuenta") String ccuenta, @PathVariable(value = "saldo") BigDecimal saldo){
        return new ResponseEntity<>(cuentaService.modificarCuenta(ccuenta,saldo), HttpStatus.OK);
    }
}
