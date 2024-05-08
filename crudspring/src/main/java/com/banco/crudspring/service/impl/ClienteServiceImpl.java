package com.banco.crudspring.service.impl;

import com.banco.crudspring.dao.ClienteDAO;
import com.banco.crudspring.dao.CuentaDAO;
import com.banco.crudspring.interceptor.exceptions.AppException;
import com.banco.crudspring.modelos.ClienteCuentaDTO;
import com.banco.crudspring.modelos.ClienteDTO;
import com.banco.crudspring.modelos.CuentaDTO;
import com.banco.crudspring.service.ClienteService;
import com.banco.crudspring.util.Cifrar;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteDAO clienteDAO;

    @Autowired
    private CuentaDAO cuentaDAO;

    @Override
    public ClienteDTO guardarCliente(ClienteDTO clienteDTO){
        return clienteDAO.saveCliente(clienteDTO);
    }

    @Override
    public ClienteDTO eliminarCliente(Integer id) {
        ClienteDTO cliente = clienteDAO.buscarClienteId(id);
        if(cliente != null){
            cliente.setEstado("I");
            return clienteDAO.saveCliente(cliente);
        }
        throw new AppException("Cliente no existe");
    }

    @SneakyThrows
    @Override
    public ClienteCuentaDTO buscarIdentificacion(String id) {
        ClienteDTO clienteDTO = clienteDAO.buscarClienteIdentificacion(id);
        Cifrar.cifra(clienteDTO.getCcliente().toString());
        List<CuentaDTO> listCuentas = cuentaDAO.buscarCuentaCliente(clienteDTO.getCcliente());

        return ClienteCuentaDTO.builder().nombre(clienteDTO.getNombre()).codigo(Cifrar.cifra(clienteDTO.getCcliente()
                .toString())).cuentaDTOS(listCuentas).build();
    }
}
