package com.banco.crudspring.service;

import com.banco.crudspring.modelos.ClienteCuentaDTO;
import com.banco.crudspring.modelos.ClienteDTO;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ClienteService {
    ClienteDTO guardarCliente(ClienteDTO clienteDTO);

    ClienteDTO eliminarCliente(Integer id);

    ClienteCuentaDTO buscarIdentificacion(String id);
}
