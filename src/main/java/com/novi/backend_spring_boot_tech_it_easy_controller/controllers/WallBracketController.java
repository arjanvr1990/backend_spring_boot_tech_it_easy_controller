package com.novi.backend_spring_boot_tech_it_easy_controller.controllers;

import com.novi.backend_spring_boot_tech_it_easy_controller.dtos.WallBracketDto;
import com.novi.backend_spring_boot_tech_it_easy_controller.dtos.WallBracketInputDto;
import com.novi.backend_spring_boot_tech_it_easy_controller.services.WallBracketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wallbrackets")
public class WallBracketController {

    private final WallBracketService wallBracketService;

    @Autowired
    public WallBracketController(WallBracketService wallBracketService) {
        this.wallBracketService = wallBracketService;
    }


    @GetMapping
    public ResponseEntity<List<WallBracketDto>> getAllWallBrackets() {
        List<WallBracketDto> wallBrackets = wallBracketService.getAllWallBrackets();
        return new ResponseEntity<>(wallBrackets, HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<WallBracketDto> updateWallBracket(@PathVariable Long id, @RequestBody WallBracketDto wallBracketDto) {
        WallBracketDto updatedWallBracket = wallBracketService.updateWallBracket(id, wallBracketDto);
        return new ResponseEntity<>(updatedWallBracket, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<WallBracketDto> createWallBracket(@Valid @RequestBody WallBracketInputDto wallBracketInputDto) {
        WallBracketDto createdWallBracket = wallBracketService.createWallBracket(wallBracketInputDto);
        return new ResponseEntity<>(createdWallBracket, HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWallBracket(@PathVariable Long id) {
        wallBracketService.deleteWallBracket(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

