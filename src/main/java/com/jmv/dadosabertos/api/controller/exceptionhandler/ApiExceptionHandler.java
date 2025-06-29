package com.jmv.dadosabertos.api.controller.exceptionhandler;

import com.jmv.dadosabertos.exception.EntidadeNaoEncontradaException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(ApiExceptionHandler.class);

    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    public ResponseEntity<Object> handleEntidadeNaoEncontrada(EntidadeNaoEncontradaException ex, WebRequest request) {
        var status = HttpStatus.NOT_FOUND;

        var problem = Problem.builder()
                .status(status.value())
                .type(ProblemType.RECURSO_NAO_ENCONTRADO.getUri())
                .title(ProblemType.RECURSO_NAO_ENCONTRADO.getTitle())
                .detail(ex.getMessage())
                .timestamp(OffsetDateTime.now())
                .build();

        LOG.warn(ex.getMessage());

        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleErroGenerico(Exception ex, WebRequest request) {
        var status = HttpStatus.INTERNAL_SERVER_ERROR;

        var problem = Problem.builder()
                .status(status.value())
                .type(ProblemType.ERRO_DE_SISTEMA.getUri())
                .title(ProblemType.ERRO_DE_SISTEMA.getTitle())
                .detail("Ocorreu um erro inesperado. Tente novamente mais tarde.")
                .timestamp(OffsetDateTime.now())
                .build();

        LOG.error("Erro inesperado na aplicação", ex);

        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
    }

}
