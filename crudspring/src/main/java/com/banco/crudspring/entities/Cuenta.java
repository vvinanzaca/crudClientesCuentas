package com.banco.crudspring.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "tcuenta")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cuenta {

    @EmbeddedId
    private CuentaPk cuentaPk;

    @Column(name = "saldo")
    private BigDecimal saldo;

    @Column(name = "fmodificacion")
    private Timestamp fmodificacion;

    @Column(name = "fcreacion")
    private Timestamp fcreacion;

    @Column(name = "tipocuenta")
    private String tipocuenta;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "ccliente")
    private Cliente cliente;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
