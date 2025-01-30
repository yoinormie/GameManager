package com.yoi.GameManager.Exceptions.Appuser;

import com.yoi.GameManager.Exceptions.ErrorMessages;

public class UserNotFound extends RuntimeException {
    public UserNotFound() {
        super(ErrorMessages.UNIDENTIFIED_USER.getMessage());
    }
}
