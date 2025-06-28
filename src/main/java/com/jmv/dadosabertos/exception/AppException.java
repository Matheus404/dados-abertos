package com.jmv.dadosabertos.exception;

public abstract class AppException extends RuntimeException {

    protected AppException(String mensagem) {
        super(mensagem);
    }

    protected AppException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}

