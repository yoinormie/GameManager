package com.yoi.GameManager.Exceptions;

import lombok.Getter;

@Getter
public enum ErrorMessages {
    OWNER_NOT_FOUND("El usuario no ha sido encontrado ");

    private String message;
    //private int statusCode;

    ErrorMessages(String message) {
        this.message = message;
      //  this.statusCode = statusCode;
    }


}
