package com.yoi.GameManager.Exceptions.Owner;

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
