package com.novi.backend_spring_boot_tech_it_easy_controller.exceptions;


public class RecordNotFoundException extends RuntimeException {
    public RecordNotFoundException(String message) {
        super(message);
    }
}