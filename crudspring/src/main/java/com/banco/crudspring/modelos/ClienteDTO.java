package com.banco.crudspring.modelos;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class ClienteDTO {

    private Integer ccliente;
    private String identificacion;
    private String nombre;
    private String apellido;
    private Date fnacimiento;
    private String telefono;
    private String correo;
    private String estado;

}
