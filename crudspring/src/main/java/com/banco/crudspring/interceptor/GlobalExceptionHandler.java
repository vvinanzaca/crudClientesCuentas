package com.banco.crudspring.interceptor;

import com.banco.crudspring.interceptor.exceptions.AppException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {


    private static final Logger LOGGER = LogManager.getLogger(GlobalExceptionHandler.class);
    private static final String STANDARD_ERROR = "Error interno, por favor intenta de nuevo";

    @ExceptionHandler({Exception.class})
    public final ResponseEntity<ApiMensaje> handleException(Exception ex) {
        ex.printStackTrace();
        LOGGER.error("[ERROR] " + ex.getClass().getSimpleName());
        if (ex instanceof AppException) {
            AppException ue = (AppException) ex;
            return manejarAppException(ue);
        } else {
            return new ResponseEntity<>(ApiMensaje.builder()
                                                .mensaje(STANDARD_ERROR)
                                                .codigo("-1")
                                                .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<ApiMensaje> manejarAppException(AppException exception) {
        return new ResponseEntity<>(ApiMensaje.builder()
                                            .mensaje(exception.getMessage())
                                            .codigo("-1")
                                            .build(), HttpStatus.BAD_REQUEST);
    }

}
