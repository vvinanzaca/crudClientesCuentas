package com.banco.crudspring.dao.impl;

import com.banco.crudspring.dao.CuentaDAO;
import com.banco.crudspring.entities.Cliente;
import com.banco.crudspring.entities.Cuenta;
import com.banco.crudspring.entities.CuentaPk;
import com.banco.crudspring.interceptor.exceptions.AppException;
import com.banco.crudspring.modelos.CuentaDTO;
import com.banco.crudspring.util.ApplicationDates;
import com.banco.crudspring.util.EntitiesCast;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CuentaDAOImpl implements CuentaDAO {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    @Transactional
    public CuentaDTO guardarCuenta(CuentaDTO cuentaDTO) {
        entityManager.merge(EntitiesCast.getCuentaEntity(cuentaDTO));
        return cuentaDTO;
    }

    @Override
    public CuentaDTO buscarCuentaPk(CuentaDTO cuentaDTO) {
        CuentaPk pk = CuentaPk.builder().ccuenta(cuentaDTO.getCcuenta()).fhasta(cuentaDTO.getFhasta()).build();
        return EntitiesCast.getCuentaDTO(entityManager.find(Cuenta.class,pk));
    }

    @Override
    public List<CuentaDTO> buscarCuentaCliente(Integer ccliente) {
        String jpql = "SELECT c FROM Cuenta c WHERE c.cliente.ccliente = :ccliente and c.id.fhasta = :fhasta";
        Query query = entityManager.createQuery(jpql, Cuenta.class);
        query.setParameter("ccliente", ccliente);
        query.setParameter("fhasta", ApplicationDates.DEFAULT_EXPIRY_TIMESTAMP);
        List<Cuenta> listCuentas = query.getResultList();
        if(listCuentas.isEmpty()){
            return new ArrayList<>();
        }
        return EntitiesCast.getCuentaDTO(listCuentas);
    }
}
