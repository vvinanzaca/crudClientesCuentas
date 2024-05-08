package com.banco.crudspring.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Timestamp;

@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CuentaPk implements Serializable {

    private static final long serialVersionUID = 7148933691072842071L;
    @Column(name = "ccuenta", nullable = false)
    private String ccuenta;
    @Column(name = "fhasta", nullable = false)
    private Timestamp fhasta;
}
