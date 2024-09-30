package com.novi.backend_spring_boot_tech_it_easy_controller.services;

import com.novi.backend_spring_boot_tech_it_easy_controller.dtos.RemoteControllerDto;
import com.novi.backend_spring_boot_tech_it_easy_controller.dtos.TelevisionDto;
import com.novi.backend_spring_boot_tech_it_easy_controller.dtos.TelevisionInputDto;
import com.novi.backend_spring_boot_tech_it_easy_controller.exceptions.RecordNotFoundException;
import com.novi.backend_spring_boot_tech_it_easy_controller.models.RemoteController;
import com.novi.backend_spring_boot_tech_it_easy_controller.models.Television;
import com.novi.backend_spring_boot_tech_it_easy_controller.repositories.RemoteControllerRepository;
import com.novi.backend_spring_boot_tech_it_easy_controller.repositories.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository;
    private final RemoteControllerRepository remoteControllerRepository;

    @Autowired
    public TelevisionService(TelevisionRepository televisionRepository, RemoteControllerRepository remoteControllerRepository) {
        this.televisionRepository = televisionRepository;
        this.remoteControllerRepository = remoteControllerRepository;
    }

    public List<TelevisionDto> getAllTelevisions() {
        List<Television> televisionsList = televisionRepository.findAll();
        return televisionsList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public TelevisionDto updateTelevision(Long id, TelevisionDto televisionInputDto) {
        Television television = televisionRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Television not found"));

        // Bijwerken van Television object met nieuwe gegevens
        television.setName(televisionInputDto.getName());
        television.setBrand(televisionInputDto.getBrand());
        television.setPrice(televisionInputDto.getPrice());
        television.setAvailableSize(televisionInputDto.getAvailableSize());
        television.setRefreshRate(televisionInputDto.getRefreshRate());
        television.setScreenType(televisionInputDto.getScreenType());
        television.setScreenQuality(televisionInputDto.getScreenQuality());
        television.setSmartTv(televisionInputDto.getSmartTv());
        television.setWifi(televisionInputDto.getWifi());
        television.setVoiceControl(televisionInputDto.getVoiceControl());
        television.setHdr(televisionInputDto.getHdr());
        television.setBluetooth(televisionInputDto.getBluetooth());
        television.setAmbiLight(televisionInputDto.getAmbiLight());
        television.setOriginalStock(televisionInputDto.getOriginalStock());
        television.setSold(televisionInputDto.getSold());

        // Controleer of er een gekoppelde RemoteController is
        if (television.getRemoteController() != null) {
            RemoteControllerDto remoteControllerDto = convertToRemoteControllerDto(television.getRemoteController());
            televisionInputDto.setRemoteController(remoteControllerDto);  // Stel de remoteController in het DTO object in
        }

        television = televisionRepository.save(television);
        return convertToDto(television);  // Return het bijgewerkte DTO
    }

    private RemoteControllerDto convertToRemoteControllerDto(RemoteController remoteController) {
        RemoteControllerDto dto = new RemoteControllerDto();
        dto.setId(remoteController.getId());
        dto.setName(remoteController.getName());
        dto.setBrand(remoteController.getBrand());
        dto.setPrice(remoteController.getPrice());
        return dto;
    }

    public TelevisionDto createTelevision(TelevisionInputDto inputDto) {
        Television television = new Television();
        television.setName(inputDto.getName());
        television.setBrand(inputDto.getBrand());
        television.setPrice(inputDto.getPrice());
        television.setAvailableSize(inputDto.getAvailableSize());
        television.setRefreshRate(inputDto.getRefreshRate());
        television.setScreenType(inputDto.getScreenType());
        television.setScreenQuality(inputDto.getScreenQuality());
        television.setSmartTv(inputDto.getSmartTv());
        television.setWifi(inputDto.getWifi());
        television.setVoiceControl(inputDto.getVoiceControl());
        television.setHdr(inputDto.getHdr());
        television.setBluetooth(inputDto.getBluetooth());
        television.setAmbiLight(inputDto.getAmbiLight());
        television.setOriginalStock(inputDto.getOriginalStock());
        television.setSold(inputDto.getSold());

        television = televisionRepository.save(television);
        return convertToDto(television);
    }

    private TelevisionDto convertToDto(Television television) {
        TelevisionDto dto = new TelevisionDto();
        dto.setId(television.getId());
        dto.setName(television.getName());
        dto.setBrand(television.getBrand());
        dto.setPrice(television.getPrice());
        dto.setAvailableSize(television.getAvailableSize());
        dto.setRefreshRate(television.getRefreshRate());
        dto.setScreenType(television.getScreenType());
        dto.setScreenQuality(television.getScreenQuality());
        dto.setSmartTv(television.getSmartTv());
        dto.setWifi(television.getWifi());
        dto.setVoiceControl(television.getVoiceControl());
        dto.setHdr(television.getHdr());
        dto.setBluetooth(television.getBluetooth());
        dto.setAmbiLight(television.getAmbiLight());
        dto.setOriginalStock(television.getOriginalStock());
        dto.setSold(television.getSold());

        // Voeg de RemoteController toe aan het Television DTO als deze bestaat
        if (television.getRemoteController() != null) {
            RemoteControllerDto remoteControllerDto = convertToRemoteControllerDto(television.getRemoteController());
            dto.setRemoteController(remoteControllerDto);
        }

        return dto;
    }

    public void deleteTelevision(Long id) {
        boolean exists = televisionRepository.existsById(id);
        if (!exists) {
            throw new RecordNotFoundException("Television with ID " + id + " not found");
        }
        televisionRepository.deleteById(id);
    }

    public void linkRemoteControllerToTelevision(Long televisionId, Long remoteControllerId) {
        Television television = televisionRepository.findById(televisionId)
                .orElseThrow(() -> new RecordNotFoundException("Television not found"));
        RemoteController remoteController = remoteControllerRepository.findById(remoteControllerId)
                .orElseThrow(() -> new RecordNotFoundException("RemoteController not found"));

        television.setRemoteController(remoteController);
        televisionRepository.save(television);
    }
}
