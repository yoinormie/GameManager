package com.yoi.GameManager.Exceptions.Owner;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OwnerNotFound extends RuntimeException {

    public OwnerNotFound() {
    }

    public OwnerNotFound(String message) {
        super(message);
    }

    public OwnerNotFound(Long id, String msg) {
        super(msg + String.valueOf(id));
    }
}
