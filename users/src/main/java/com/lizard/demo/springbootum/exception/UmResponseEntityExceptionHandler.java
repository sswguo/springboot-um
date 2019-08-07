package com.lizard.demo.springbootum.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class UmResponseEntityExceptionHandler extends ResponseEntityExceptionHandler
{

    @ExceptionHandler(UserExistsException.class)
    public final ResponseEntity<ErrorInfo> handleUserExistsException( UserExistsException ue, WebRequest request )
    {
        ErrorInfo errorInfo = new ErrorInfo( ue.getMessage(), new Date() );
        return new ResponseEntity<>( errorInfo, HttpStatus.BAD_REQUEST );
    }

}
