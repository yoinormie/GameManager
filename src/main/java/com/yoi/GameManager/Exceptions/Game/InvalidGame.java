package com.yoi.GameManager.Exceptions.Game;

import com.yoi.GameManager.Exceptions.ErrorMessages;

public class InvalidGame extends RuntimeException {
    public InvalidGame() {
        super(ErrorMessages.INVALID_GAME.getMessage());
    }
}
