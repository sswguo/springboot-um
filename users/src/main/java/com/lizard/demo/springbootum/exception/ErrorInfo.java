package com.lizard.demo.springbootum.exception;

import java.util.Date;

public class ErrorInfo
{

    private String message;
    private Date timestamp;

    public ErrorInfo( String message, Date timestamp )
    {
        super();
        this.message = message;
        this.timestamp = timestamp;
    }
}
