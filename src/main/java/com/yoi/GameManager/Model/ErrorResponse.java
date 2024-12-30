package com.yoi.GameManager.Model;

import lombok.Getter;

@Getter

public class ErrorResponse {
    private String message;
    //private int statusCode;

    public ErrorResponse(String message) {
        this.message = message;
        //this.statusCode = statusCode;
    }
}
