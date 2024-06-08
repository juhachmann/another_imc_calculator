package org.example.model.imc.exception;

public class ClassificadorNaoEncontradoException extends RuntimeException {

    public ClassificadorNaoEncontradoException() {
    }

    public ClassificadorNaoEncontradoException(String message) {
        super(message);
    }
}
