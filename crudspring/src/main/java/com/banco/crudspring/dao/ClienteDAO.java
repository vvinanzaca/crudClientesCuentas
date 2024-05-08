package com.banco.crudspring.dao;

import com.banco.crudspring.modelos.ClienteDTO;

import java.util.List;

public interface ClienteDAO {

    ClienteDTO saveCliente(ClienteDTO clienteDTO);

    ClienteDTO buscarClienteId(Integer id);

    ClienteDTO buscarClienteIdentificacion(String identificacion);
}
