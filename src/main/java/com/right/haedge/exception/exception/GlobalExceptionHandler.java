package com.right.haedge.exception.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Controller에 적합한 request DTO가 셋팅이 되어있지 않았다.
     * BAD REQUEST 400 error
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> requestValidException(MethodArgumentNotValidException ex){
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMsg = error.getDefaultMessage();
            log.info("fieldName : {} errorMsg : {} ", fieldName, errorMsg);
        });
        return new ResponseEntity<>("Bad Request", HttpStatus.BAD_REQUEST);
    }

}
