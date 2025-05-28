package com.yoi.GameManager.Exceptions;

import lombok.Getter;

@Getter
public enum ErrorMessages {
    USER_NOT_VALID("El usuario no es válido"),
    USER_NOT_FOUND("El usuario no ha sido encontrado"),
    INCORRECT_PASSWORD("La contraseña que se ha proporcionado no es correcta"),
    UNABLE_TO_DESERIALIZE_USER("El user no ha podido ser deserializado");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }
}
