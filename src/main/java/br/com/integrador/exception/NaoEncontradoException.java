package br.com.integrador.exception;

public class NaoEncontradoException extends Exception {

    public NaoEncontradoException(String msg) {
        super(msg);
    }

    public NaoEncontradoException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
