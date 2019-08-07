package com.lizard.demo.springbootum.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( HttpStatus.BAD_REQUEST )
public class UserExistsException extends RuntimeException
{
    public UserExistsException( String exception )
    {
        super(exception);
    }
}
