package com.novi.backend_spring_boot_tech_it_easy_controller.controllers;

import com.novi.backend_spring_boot_tech_it_easy_controller.models.TelevisionRequest;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RequestMapping("/api/televisions")
public class TelevisionsController {

    @GetMapping
    @ResponseBody
    public String getAllTelevisions() {
        return "List Televisions";
    }

    @GetMapping("/{model}")
    @ResponseBody
    public ResponseEntity<String> getTelevision(@PathVariable String model) {
        String responseBody = "Type television " + model;
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @PostMapping
    @PutMapping("/{id}")
    public ResponseEntity<String> createTelevision(@RequestBody TelevisionRequest televisionRequest) {
        String responseMessage = String.format("Television received: %s", televisionRequest.getName());
        return new ResponseEntity<>(responseMessage, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTelevision(@PathVariable("id") Long id,
                                                   @RequestBody TelevisionRequest televisionRequest) {
        String responseMessage = String.format("Television with ID %d updated: %s",
                id, televisionRequest.getName());
        return new ResponseEntity<>(responseMessage, HttpStatus.NO_CONTENT);
    }
}
