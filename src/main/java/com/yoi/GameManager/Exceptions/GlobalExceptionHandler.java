package com.yoi.GameManager.Exceptions;

import com.yoi.GameManager.Exceptions.Owner.OwnerNotFound;
import com.yoi.GameManager.Model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(OwnerNotFound.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse OwnerNotFoundException(OwnerNotFound exception){
        return new ErrorResponse(exception.getMessage());
    }
}
