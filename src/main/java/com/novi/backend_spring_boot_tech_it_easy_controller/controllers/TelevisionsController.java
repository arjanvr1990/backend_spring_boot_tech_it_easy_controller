package com.novi.backend_spring_boot_tech_it_easy_controller.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


public class TelevisionsController {
    @GetMapping("/televisions")
    @ResponseBody
    public String getAllTelevisions() {
        return "List Televisions";
    }

    @GetMapping("/televisions/{model}")
    @ResponseBody
    public String getTelevision(@PathVariable String model) {
        return "Type television" + model;
    }

    @PostMapping("/api/television")
    public <TelevisionRequest> ResponseEntity<String> createTelevision(@RequestBody TelevisionRequest televisionRequest) {
        String responseMessage = String.format("Television received: %s", televisionRequest.getClass());

        return new ResponseEntity<>(responseMessage, HttpStatus.CREATED);
    }


    public <TelevisionRequest> ResponseEntity<String> updateTelevision(@PathVariable("id") Long id,
                                                                       @RequestBody TelevisionRequest televisionRequest) {
        String responseMessage = String.format("Television with ID %d updated: %s",
                id, televisionRequest.getClass());


        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }
}
