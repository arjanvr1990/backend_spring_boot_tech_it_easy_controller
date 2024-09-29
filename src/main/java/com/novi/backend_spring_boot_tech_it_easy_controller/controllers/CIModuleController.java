package com.novi.backend_spring_boot_tech_it_easy_controller.controllers;

import com.novi.backend_spring_boot_tech_it_easy_controller.dtos.CIModuleDto;
import com.novi.backend_spring_boot_tech_it_easy_controller.dtos.CIModuleInputDto;
import com.novi.backend_spring_boot_tech_it_easy_controller.services.CIModuleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cimodule")
public class CIModuleController {

    private final CIModuleService cIModuleService;

    @Autowired
    public CIModuleController(CIModuleService cIModuleService) {
        this.cIModuleService = cIModuleService;
    }


    @GetMapping
    public ResponseEntity<List<CIModuleDto>> getAllCIModule() {
        List<CIModuleDto> cIModules = cIModuleService.getAllCIModule();
        return new ResponseEntity<>(cIModules, HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<CIModuleDto> updateCIModule(@PathVariable Long id, @RequestBody CIModuleDto ciModuleDto) {
        CIModuleDto updatedCIModule = cIModuleService.updateCIModule(id, ciModuleDto);
        return new ResponseEntity<>(updatedCIModule, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<CIModuleDto> createCIModule(@Valid @RequestBody CIModuleInputDto ciModuleInputDto) {
        CIModuleDto createdCIModule = cIModuleService.createCIModule(ciModuleInputDto);
        return new ResponseEntity<>(createdCIModule, HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCIModule(@PathVariable Long id) {
        cIModuleService.deleteCIModule(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
