package com.yoi.GameManager.Exceptions;

import lombok.Getter;

@Getter
public enum ErrorMessages {
    USER_NOT_VALID("El usuario no es válido"),
    USER_NOT_FOUND("El usuario no ha sido encontrado"),
    UNIDENTIFIED_USER("El usuario que has puesto no ha sido identificado"),
    OWNER_NOT_FOUND("El propietario no ha sido encontrado "),
    UNABLE_TO_INSTANCE("Esta clase no es posible de instanciar ");

    private String message;

    ErrorMessages(String message) {
        this.message = message;
    }


}
