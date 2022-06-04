package com.contract.management.system.exception;

import com.contract.management.system.constans.ExceptionClassType;
import org.springframework.http.HttpStatus;

public class BaseException extends Exception
{
    private static final long serialVersionUID = 1234567890123456789L;

    private ExceptionClassType exceptionClassType;
    private HttpStatus httpStatus;

    public BaseException(ExceptionClassType exceptionClassType, HttpStatus httpStatus, String massage)
    {
        super(exceptionClassType.toString() + massage);
        this.exceptionClassType = exceptionClassType;
        this.httpStatus = httpStatus;
    }

    public ExceptionClassType getExceptionClass()
    {
        return exceptionClassType;
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
