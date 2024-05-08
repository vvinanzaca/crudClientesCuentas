package com.banco.crudspring.controller;

import com.banco.crudspring.modelos.ClienteCuentaDTO;
import com.banco.crudspring.modelos.ClienteDTO;
import com.banco.crudspring.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clientes/")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;


    @PostMapping("/guardarCliente")
    public ResponseEntity<ClienteDTO> saveCliente(@RequestBody ClienteDTO clienteDTO) {
        clienteService.guardarCliente(clienteDTO);
        return  new ResponseEntity<>(clienteService.guardarCliente(clienteDTO), HttpStatus.CREATED);
    }

    @PutMapping("/eliminar/{id}")
    public ResponseEntity<ClienteDTO> updateState(@PathVariable(value = "id") Integer id){
        return new ResponseEntity<>(clienteService.eliminarCliente(id), HttpStatus.OK);
    }

    @GetMapping(value = "/buscaId/{identificacion}")
    public ResponseEntity<ClienteCuentaDTO> getAllActivos(@PathVariable(value = "identificacion") String identificacion){
        return new ResponseEntity<>(clienteService.buscarIdentificacion(identificacion), HttpStatus.OK);
    }

}
