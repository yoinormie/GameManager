package com.yoi.GameManager.Exceptions.Appuser;

import com.yoi.GameManager.Exceptions.ErrorMessages;

public class UserNotDeserialized extends RuntimeException {
    public UserNotDeserialized() {
        super(ErrorMessages.UNABLE_TO_DESERIALIZE_USER.getMessage());
    }
}
