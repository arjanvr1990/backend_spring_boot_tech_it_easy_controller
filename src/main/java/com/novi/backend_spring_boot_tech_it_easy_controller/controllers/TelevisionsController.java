package com.novi.backend_spring_boot_tech_it_easy_controller.controllers;

import com.novi.backend_spring_boot_tech_it_easy_controller.dtos.IdInputDto;
import com.novi.backend_spring_boot_tech_it_easy_controller.dtos.TelevisionDto;
import com.novi.backend_spring_boot_tech_it_easy_controller.dtos.TelevisionInputDto;
import com.novi.backend_spring_boot_tech_it_easy_controller.services.TelevisionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/televisions")
public class TelevisionsController {

    private final TelevisionService televisionService;

    @Autowired
    public TelevisionsController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }


    @GetMapping
    public ResponseEntity<List<TelevisionDto>> getAllTelevisions() {
        List<TelevisionDto> televisions = televisionService.getAllTelevisions();
        return new ResponseEntity<>(televisions, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelevisionDto> updateTelevision(@PathVariable Long id, @RequestBody TelevisionDto televisionDto) {
        TelevisionDto updatedTelevision = televisionService.updateTelevision(id, televisionDto);
        return new ResponseEntity<>(updatedTelevision, HttpStatus.OK);
    }

    @PutMapping("/{id}/remotecontroller")
    public ResponseEntity<Void> assignRemoteControllerToTelevision(@PathVariable("id") Long televisionId, @RequestBody TelevisionInputDto remoteControllerIdInput) {
        televisionService.linkRemoteControllerToTelevision(televisionId, remoteControllerIdInput.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



    @PutMapping("/{id}/remotecontroller")
    public ResponseEntity<Void> assignRemoteControllerToTelevision(@PathVariable("id") Long televisionId, @RequestBody IdInputDto remoteControllerIdInput) {
        televisionService.linkRemoteControllerToTelevision(televisionId, remoteControllerIdInput.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelevision(@PathVariable Long id) {
        televisionService.deleteTelevision(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
