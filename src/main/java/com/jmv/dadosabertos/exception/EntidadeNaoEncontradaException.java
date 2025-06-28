package com.jmv.dadosabertos.exception;

public class EntidadeNaoEncontradaException extends AppException {

    public EntidadeNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

    public EntidadeNaoEncontradaException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
