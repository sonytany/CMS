package com.contract.management.system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalControllerAdvice
{
    @ExceptionHandler(value = BaseException.class)
    public ResponseEntity<Map<String,Object>> exceptionHandler(BaseException e)
    {
        Map<String,Object> map = new HashMap<>();
        map.put("error type", e.getHttpStatusType());
        map.put("code", Integer.toString(e.getHttpsStatusCode()));
        map.put("message", e.getMessage());

        return ResponseEntity.status(e.getHttpStatus()).body(map);
    }

    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity<Map<String,Object>> exceptionHandler(NullPointerException e)
    {
        Map<String,Object> map = new HashMap<>();
        map.put("error type", e.toString());
        map.put("code", HttpStatus.INTERNAL_SERVER_ERROR.value());
        map.put("message", "NullPointerException이 발생했습니다.");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,Object>> exceptionHandler(MethodArgumentNotValidException e)
    {
        Map<String,Object> map = new HashMap<>();
        map.put("error type", e.toString());
        map.put("code", HttpStatus.BAD_REQUEST.value());
        map.put("message", "전달 인자값에 오류가 있습니다.");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
    }
}
