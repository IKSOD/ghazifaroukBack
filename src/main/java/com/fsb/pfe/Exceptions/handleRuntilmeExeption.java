package com.fsb.pfe.Exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class handleRuntilmeExeption {

@ExceptionHandler(Exception.class)
    public ErrorExeption handleRuntimeExption(WebRequest webRequest  , Exception ex )
{
    ErrorExeption error = new ErrorExeption();
    error.setDescription(webRequest.getDescription(false));
    error.setMessage(ex.getMessage());
    error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.name());

    return error;
}
}
