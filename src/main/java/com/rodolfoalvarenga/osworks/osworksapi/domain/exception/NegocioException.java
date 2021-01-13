package com.rodolfoalvarenga.osworks.osworksapi.domain.exception;

public class NegocioException extends RuntimeException {

    private static final long serialVersionUID;

    static {
        serialVersionUID = 1L;
    }

    public NegocioException(String message) {
        super(message);
    }
}
