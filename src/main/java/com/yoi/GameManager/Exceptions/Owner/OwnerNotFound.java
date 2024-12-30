package com.yoi.GameManager.Exceptions.Owner;

import com.yoi.GameManager.Exceptions.ErrorMessages;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OwnerNotFound extends RuntimeException {

    public OwnerNotFound() {
        super(ErrorMessages.OWNER_NOT_FOUND.getMessage());
    }

    public OwnerNotFound(Long id) {
        super(ErrorMessages.OWNER_NOT_FOUND.getMessage() + id);
    }
}
