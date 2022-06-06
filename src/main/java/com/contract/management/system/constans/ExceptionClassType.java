package com.contract.management.system.constans;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionClassType
{
    CLIENT("Client"),
    CONTRACT("Contract"),
    PRODUCT("Product"),
    COLLATERAL("Collateral");

    private String exceptionClassType;

    @Override
    public String toString()
    {
        return getExceptionClassType() + " Exception. ";
    }
}

