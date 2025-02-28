package com.yoi.GameManager.Exceptions;

import lombok.Getter;

@Getter
public enum ErrorMessages {
    USER_NOT_VALID("El usuario no es válido"),
    USER_NOT_FOUND("El usuario no ha sido encontrado"),
    INCORRECT_PASSWORD("La contraseña que se ha proporcionado no es correcta"),
    UNIDENTIFIED_USER("El usuario que has puesto no ha sido identificado"),
    UNABLE_TO_DESERIALIZE_USER("El user no ha podido ser deserializado"),
    OWNER_NOT_FOUND("El propietario no ha sido encontrado "),
    INVALID_OWNER("El owner no es válido"),
    UNABLE_TO_INSTANCE("Esta clase no es posible de instanciar "),
    GAME_NOT_FOUND("El juego no ha sido encontrado"),
    INVALID_GAME("El juego es inválido");

    private String message;

    ErrorMessages(String message) {
        this.message = message;
    }
}
