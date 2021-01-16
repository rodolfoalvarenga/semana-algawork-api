package com.rodolfoalvarenga.osworks.osworksapi.domain.exception;

public class EntidadeNaoEncontradaException extends NegocioException {

    private static final long serialVersionUID;

    static {
        serialVersionUID = 1L;
    }

    public EntidadeNaoEncontradaException(String message) {
        super(message);
    }
}
