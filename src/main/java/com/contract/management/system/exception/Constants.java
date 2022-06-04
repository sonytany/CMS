package com.contract.management.system.exception;

public class Constants
{
    public enum ExceptionClass
    {
        PRODUCT("Product"), COLLATERAL("Collateral");

        private String exceptionClass;

        ExceptionClass(String exceptionClass)
        {
            this.exceptionClass = exceptionClass;
        }

        public String getExceptionClass()
        {
            return exceptionClass;
        }

        @Override
        public String toString()
        {
            return getExceptionClass() + " Exception. ";
        }
    }
}

