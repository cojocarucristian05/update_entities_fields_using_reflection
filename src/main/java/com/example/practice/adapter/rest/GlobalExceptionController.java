package com.example.practice.adapter.rest;

import com.example.practice.domain.exceptions.StudentNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Log4j2
public class GlobalExceptionController {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<Object> exception(StudentNotFoundException studentNotFoundException) {
        log.error(studentNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(studentNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> exception(IllegalArgumentException illegalArgumentException) {
        log.error(illegalArgumentException.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(illegalArgumentException.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
