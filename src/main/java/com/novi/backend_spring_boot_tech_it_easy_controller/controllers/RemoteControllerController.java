package com.novi.backend_spring_boot_tech_it_easy_controller.controllers;

import com.novi.backend_spring_boot_tech_it_easy_controller.dtos.RemoteControllerDto;
import com.novi.backend_spring_boot_tech_it_easy_controller.dtos.RemoteControllerInputDto;
import com.novi.backend_spring_boot_tech_it_easy_controller.services.RemoteControllerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/remotecontrollers")
public class RemoteControllerController {

    private final RemoteControllerService remoteControllerService;

    @Autowired
    public RemoteControllerController(RemoteControllerService remoteControllerService) {
        this.remoteControllerService = remoteControllerService;
    }


    @GetMapping
    public ResponseEntity<List<RemoteControllerDto>> getAllRemoteControllers() {
        List<RemoteControllerDto> remoteControllers = remoteControllerService.getAllRemoteControllers();
        return new ResponseEntity<>(remoteControllers, HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<RemoteControllerDto> updateRemoteController(@PathVariable Long id, @RequestBody RemoteControllerDto remoteControllerDto) {
        RemoteControllerDto updatedRemoteController = remoteControllerService.updateRemoteController(id, remoteControllerDto);
        return new ResponseEntity<>(updatedRemoteController, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<RemoteControllerDto> createRemoteController(@Valid @RequestBody RemoteControllerInputDto remoteControllerInputDto) {
        RemoteControllerDto createdRemoteController = remoteControllerService.createRemoteController(remoteControllerInputDto);
        return new ResponseEntity<>(createdRemoteController, HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRemoteController(@PathVariable Long id) {
        remoteControllerService.deleteRemoteController(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
