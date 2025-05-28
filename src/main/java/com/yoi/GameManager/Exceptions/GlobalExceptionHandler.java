package com.yoi.GameManager.Exceptions;

import com.yoi.GameManager.Exceptions.Appuser.IncorrectPassword;
import com.yoi.GameManager.Exceptions.Appuser.UserNotDeserialized;
import com.yoi.GameManager.Exceptions.Appuser.UserNotFound;
import com.yoi.GameManager.Exceptions.Appuser.UserNotValid;

import com.yoi.GameManager.Model.ErrorResponse;
import jakarta.persistence.ElementCollection;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(UserNotFound.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse UserNotFoundException(UserNotFound exception){
        return new ErrorResponse(exception.getMessage());
    }

    @ExceptionHandler(UserNotValid.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ErrorResponse UserNotValidException(UserNotValid exception){
        return new ErrorResponse(exception.getMessage());
    }

    @ExceptionHandler(IncorrectPassword.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NON_AUTHORITATIVE_INFORMATION)
    public ErrorResponse IncorrectPasswordException(IncorrectPassword exception){
        return new ErrorResponse(exception.getMessage());
    }

    @ExceptionHandler(UserNotDeserialized.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ErrorResponse UnableToDeserialize(UserNotDeserialized exception){
        return new ErrorResponse(exception.getMessage());
    }

}
