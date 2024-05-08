package com.banco.crudspring.interceptor;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class ApiMensaje {
    private String mensaje;
    private String codigo;
}
