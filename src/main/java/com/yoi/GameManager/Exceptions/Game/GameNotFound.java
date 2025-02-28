package com.yoi.GameManager.Exceptions.Game;

import com.yoi.GameManager.Exceptions.ErrorMessages;

public class GameNotFound extends RuntimeException {
    public GameNotFound() {
        super(ErrorMessages.GAME_NOT_FOUND.getMessage());
    }
}
