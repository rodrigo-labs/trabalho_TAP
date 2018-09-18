package br.com.integrador.exception;

public class HabilitacaoInvalidaException extends Exception {

    public HabilitacaoInvalidaException(String msg) {
        super(msg);
    }

    public HabilitacaoInvalidaException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
