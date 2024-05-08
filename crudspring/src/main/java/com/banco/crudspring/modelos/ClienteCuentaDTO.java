package com.banco.crudspring.modelos;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ClienteCuentaDTO {

    private String codigo;

    private String nombre;

    List<CuentaDTO> cuentaDTOS;
}
