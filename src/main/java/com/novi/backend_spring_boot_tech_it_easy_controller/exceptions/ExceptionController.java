package com.novi.backend_spring_boot_tech_it_easy_controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(TelevisionNotFoundException.class)
    public ResponseEntity<String> handleTelevisionNotFoundException(TelevisionNotFoundException ex) {
        // Return een response met een aangepaste boodschap en een statuscode
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        // Return een algemene foutmelding voor andere exceptions
        return new ResponseEntity<>("An error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
