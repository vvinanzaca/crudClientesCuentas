package com.banco.crudspring.util;

import com.banco.crudspring.entities.Cliente;
import com.banco.crudspring.entities.Cuenta;
import com.banco.crudspring.entities.CuentaPk;
import com.banco.crudspring.modelos.ClienteDTO;
import com.banco.crudspring.modelos.CuentaDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EntitiesCast {

    public static Cliente getClienteEntity(ClienteDTO clienteDTO) {
        return Cliente.builder().ccliente(clienteDTO.getCcliente()).correo(clienteDTO.getCorreo()).estado(clienteDTO.getEstado())
                .fnacimiento(clienteDTO.getFnacimiento()).identificacion(clienteDTO.getIdentificacion())
                .nombre(clienteDTO.getNombre()).apellido(clienteDTO.getApellido()).telefono(clienteDTO.getTelefono()).build();
    }

    public static ClienteDTO getClienteDTO(Cliente cliente) {
        return cliente!=null ? ClienteDTO.builder().ccliente(cliente.getCcliente()).correo(cliente.getCorreo()).estado(cliente.getEstado())
                .fnacimiento(cliente.getFnacimiento()).identificacion(cliente.getIdentificacion())
                .nombre(cliente.getNombre()).build() : null;
    }

    public static List<ClienteDTO> getClienteDTO(List<Cliente> clientes) {
        return !clientes.isEmpty() ? clientes.stream().map(EntitiesCast::getClienteDTO).collect(Collectors.toList())
                :new ArrayList<>();
    }

    public static List<CuentaDTO> getCuentaDTO(List<Cuenta> cuentas) {
        return !cuentas.isEmpty() ? cuentas.stream().map(EntitiesCast::getCuentaDTO).collect(Collectors.toList())
                :new ArrayList<>();
    }

    public static Cuenta getCuentaEntity(CuentaDTO cuentaDTO) {
        return cuentaDTO!=null ? Cuenta.builder().cuentaPk(CuentaPk.builder().ccuenta(cuentaDTO.getCcuenta()).fhasta(cuentaDTO.getFhasta()).build())
                .cliente(getClienteEntity(cuentaDTO.getClienteDTO())).fcreacion(cuentaDTO.getFcreacion()).saldo(cuentaDTO.getSaldo())
                .fmodificacion(cuentaDTO.getFmodificacion()).tipocuenta(cuentaDTO.getTipocuenta()).build():null;
    }

    public static CuentaDTO getCuentaDTO(Cuenta cuenta) {
        return cuenta!=null ? CuentaDTO.builder().ccuenta(cuenta.getCuentaPk().getCcuenta()).fhasta(cuenta.getCuentaPk().getFhasta())
                .clienteDTO(getClienteDTO(cuenta.getCliente())).fcreacion(cuenta.getFcreacion()).saldo(cuenta.getSaldo())
                .fmodificacion(cuenta.getFmodificacion()).tipocuenta(cuenta.getTipocuenta()).build():null;
    }
}
