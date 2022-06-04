package com.contract.management.system.exception;

import org.springframework.http.HttpStatus;

public class BaseException extends Exception
{
    private static final long serialVersionUID = 1234567890123456789L;

    private Constants.ExceptionClass exceptionClass;
    private HttpStatus httpStatus;

    public BaseException(Constants.ExceptionClass exceptionClass, HttpStatus httpStatus, String massage)
    {
        super(exceptionClass.toString() + massage);
        this.exceptionClass = exceptionClass;
        this.httpStatus = httpStatus;
    }

    public Constants.ExceptionClass getExceptionClass()
    {
        return exceptionClass;
    }

    public int getHttpsStatusCode()
    {
        return httpStatus.value();
    }

    public String getHttpStatusType()
    {
        return httpStatus.getReasonPhrase();
    }

    public HttpStatus getHttpStatus()
    {
        return httpStatus;
    }
}
