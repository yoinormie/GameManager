package com.yoi.GameManager.Exceptions.Appuser;

import com.yoi.GameManager.Exceptions.ErrorMessages;

public class IncorrectPassword extends RuntimeException {
    public IncorrectPassword() {
        super(ErrorMessages.INCORRECT_PASSWORD.getMessage());
    }
}
