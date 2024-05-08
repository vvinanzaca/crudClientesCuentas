package com.banco.crudspring.interceptor.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
@Getter
@Setter
public class AppException extends RuntimeException {

        private static final long serialVersionUID = 1L;

        private String mensaje;
        private String codigo;


        public AppException(String mensaje) {
                super(String.format("%s", mensaje));
                this.setMensaje(mensaje);
                this.setCodigo("-1");
        }

}
