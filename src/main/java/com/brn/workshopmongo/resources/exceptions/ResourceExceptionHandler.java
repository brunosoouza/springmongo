package com.brn.workshopmongo.resources.exceptions;

import com.brn.workshopmongo.services.exception.ObjectNofFoundException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //indica ao spring que essa classe trata erros nas requisicoes
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNofFoundException.class) //indica o erro handler que sera passado
    public ResponseEntity<StandardError> objectNotFound(ObjectNofFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Não encontrado", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
