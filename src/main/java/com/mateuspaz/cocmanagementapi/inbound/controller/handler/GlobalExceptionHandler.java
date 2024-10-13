package com.mateuspaz.cocmanagementapi.inbound.controller.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mateuspaz.cocmanagementapi.core.exception.CocManagementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final String MESSAGE = "message";

    private static final String STATUS_CODE = "status";

    @ExceptionHandler(CocManagementException.class)
    public ResponseEntity<?> handleCocManagementException(CocManagementException e) {
        Map<String, Object> body = new HashMap<>();
        body.put(STATUS_CODE, HttpStatus.BAD_REQUEST.getReasonPhrase());
        body.put(MESSAGE, e.getMessage());
        return ResponseEntity.badRequest().body(body);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e) {
        Map<String, Object> body = new HashMap<>();
        body.put(STATUS_CODE, HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        body.put(MESSAGE, e.getMessage());
        return ResponseEntity.internalServerError().body(body);
    }

}
