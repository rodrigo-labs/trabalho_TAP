package br.com.integrador.exception;

public class CargaCompletaException extends Exception {

    public CargaCompletaException(String msg) {
        super(msg);
    }

    public CargaCompletaException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
