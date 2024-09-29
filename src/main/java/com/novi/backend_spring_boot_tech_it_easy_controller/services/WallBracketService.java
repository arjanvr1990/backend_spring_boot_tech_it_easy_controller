package com.novi.backend_spring_boot_tech_it_easy_controller.services;

import com.novi.backend_spring_boot_tech_it_easy_controller.dtos.WallBracketDto;
import com.novi.backend_spring_boot_tech_it_easy_controller.dtos.WallBracketInputDto;
import com.novi.backend_spring_boot_tech_it_easy_controller.models.WallBracket;
import com.novi.backend_spring_boot_tech_it_easy_controller.repositories.WallBracketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WallBracketService {

    private final WallBracketRepository wallBracketRepository;

    @Autowired
    public WallBracketService(WallBracketRepository wallBracketRepository) {
        this.wallBracketRepository = wallBracketRepository;
    }

    public List<WallBracketDto> getAllWallBrackets() {
        List<WallBracket> wallBracketsList = wallBracketRepository.findAll();
        List<WallBracketDto> wallBracketDtoList = new ArrayList<>();

        for (WallBracket wallBracket : wallBracketsList) {
            WallBracketDto wallBracketDto = convertToDto(wallBracket);
            wallBracketDtoList.add(wallBracketDto);
        }

        return wallBracketDtoList;
    }

    public WallBracketDto getWallBracketById(Long id) {
        WallBracket wallBracket = wallBracketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("WallBracket not found"));
        return convertToDto(wallBracket);
    }

    public WallBracketDto createWallBracket(WallBracketInputDto wallBracketInputDto) {
        WallBracket wallBracket = new WallBracket();
        wallBracket.setName(wallBracketInputDto.getName());
        wallBracket.setBrand(wallBracketInputDto.getBrand());
        wallBracket.setPrice(wallBracketInputDto.getPrice());

        wallBracket = wallBracketRepository.save(wallBracket);
        return convertToDto(wallBracket);
    }

    public WallBracketDto updateWallBracket(Long id, WallBracketDto wallBracketInputDto) {
        WallBracket wallBracket = wallBracketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("WallBracket not found"));

        wallBracket.setName(wallBracketInputDto.getName());
        wallBracket.setBrand(wallBracketInputDto.getBrand());
        wallBracket.setPrice(wallBracketInputDto.getPrice());

        WallBracket updatedWallBracket = wallBracketRepository.save(wallBracket);
        return convertToDto(updatedWallBracket);
    }

    public void deleteWallBracket(Long id) {
        if (!wallBracketRepository.existsById(id)) {
            throw new RuntimeException("WallBracket not found");
        }
        wallBracketRepository.deleteById(id);
    }

    private WallBracketDto convertToDto(WallBracket wallBracket) {
        WallBracketDto dto = new WallBracketDto();
        dto.setId(wallBracket.getId());
        dto.setName(wallBracket.getName());
        dto.setBrand(wallBracket.getBrand());
        dto.setPrice(wallBracket.getPrice());
        return dto;
    }
}
