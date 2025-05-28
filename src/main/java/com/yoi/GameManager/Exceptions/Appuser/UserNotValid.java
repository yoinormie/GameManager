package com.yoi.GameManager.Exceptions.Appuser;

import com.yoi.GameManager.Exceptions.ErrorMessages;

public class UserNotValid extends RuntimeException {
    public UserNotValid() {
        super(ErrorMessages.USER_NOT_VALID.getMessage());
    }
}
