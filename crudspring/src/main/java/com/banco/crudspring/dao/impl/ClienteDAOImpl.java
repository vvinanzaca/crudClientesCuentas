package com.banco.crudspring.dao.impl;

import com.banco.crudspring.dao.ClienteDAO;
import com.banco.crudspring.entities.Cliente;
import com.banco.crudspring.interceptor.exceptions.AppException;
import com.banco.crudspring.modelos.ClienteDTO;
import com.banco.crudspring.util.EntitiesCast;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ClienteDAOImpl implements ClienteDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public ClienteDTO saveCliente(ClienteDTO clienteDTO){
        entityManager.merge(EntitiesCast.getClienteEntity(clienteDTO));
        return clienteDTO;
    }

    @Override
    @Transactional
    public ClienteDTO buscarClienteId(Integer id) {
        Cliente cliente = entityManager.find(Cliente.class, id);
        if(cliente != null){
            cliente.setEstado("I");
            return EntitiesCast.getClienteDTO(entityManager.merge(cliente));
        }
        throw new AppException("Cliente no existe");
    }

    @Override
    public ClienteDTO buscarClienteIdentificacion(String identificacion){
        String jpql = "SELECT c FROM Cliente c WHERE c.identificacion = :identificacion";
        Query query = entityManager.createQuery(jpql, Cliente.class);
        query.setParameter("identificacion", identificacion);
        List<Cliente> listClientes = query.getResultList();
        if(listClientes.isEmpty()){
            throw new AppException("Cliente no existe");
        }
        return EntitiesCast.getClienteDTO(listClientes.get(0));
    }
}
