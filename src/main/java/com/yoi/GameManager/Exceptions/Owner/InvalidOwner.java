package com.yoi.GameManager.Exceptions.Owner;

import com.yoi.GameManager.Exceptions.ErrorMessages;

public class InvalidOwner extends RuntimeException {
    public InvalidOwner() {
        super(ErrorMessages.INVALID_OWNER.getMessage());
    }
}
