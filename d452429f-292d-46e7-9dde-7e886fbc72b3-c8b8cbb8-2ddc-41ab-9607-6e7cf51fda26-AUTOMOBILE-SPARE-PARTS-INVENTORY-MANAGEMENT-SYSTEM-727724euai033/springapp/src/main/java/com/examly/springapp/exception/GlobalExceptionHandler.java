package com.examly.springapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handleGlobalException(Exception ex, WebRequest request) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body("An error occurred: " + ex.getMessage());
  }

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<String> handleRuntimeException(RuntimeException ex, WebRequest request) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body("Runtime error: " + ex.getMessage());
  }
}
