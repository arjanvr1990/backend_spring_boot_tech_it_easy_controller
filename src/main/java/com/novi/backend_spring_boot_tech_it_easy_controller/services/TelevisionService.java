package com.novi.backend_spring_boot_tech_it_easy_controller.services;

import com.novi.backend_spring_boot_tech_it_easy_controller.dtos.TelevisionDto;
import com.novi.backend_spring_boot_tech_it_easy_controller.dtos.TelevisionInputDto;
import com.novi.backend_spring_boot_tech_it_easy_controller.exceptions.RecordNotFoundException;
import com.novi.backend_spring_boot_tech_it_easy_controller.models.Television;
import com.novi.backend_spring_boot_tech_it_easy_controller.repositories.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository;

    @Autowired
    public TelevisionService(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }

    public List<TelevisionDto> getAllTelevisions() {
        List<Television> televisions = televisionRepository.findAll();
        return televisions.stream()
                .map(this::convertToDto) // Converteer elke Television naar TelevisionDto
                .collect(Collectors.toList());
    }


    public TelevisionDto createTelevision(TelevisionInputDto inputDto) {
        Television television = new Television();
        television.setName(inputDto.getName());
        television.setBrand(inputDto.getBrand());
        television.setPrice(inputDto.getPrice());


        television = televisionRepository.save(television);


        return convertToDto(television);
    }


    private TelevisionDto convertToDto(Television television) {
        TelevisionDto dto = new TelevisionDto();
        dto.setId(television.getId());
        dto.setName(television.getName());
        dto.setBrand(television.getBrand());
        dto.setPrice(television.getPrice());
        return dto;
    }

    public void deleteTelevision(Long id) {
        boolean exists = televisionRepository.existsById(id);
        if (!exists) {
            throw new RecordNotFoundException("Television with ID " + id + " not found");
        }
        televisionRepository.deleteById(id);
    }

}
