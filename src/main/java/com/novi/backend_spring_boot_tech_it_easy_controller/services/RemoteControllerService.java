package com.novi.backend_spring_boot_tech_it_easy_controller.services;

import com.novi.backend_spring_boot_tech_it_easy_controller.dtos.RemoteControllerDto;
import com.novi.backend_spring_boot_tech_it_easy_controller.dtos.RemoteControllerInputDto;
import com.novi.backend_spring_boot_tech_it_easy_controller.models.RemoteController;
import com.novi.backend_spring_boot_tech_it_easy_controller.models.Television;
import com.novi.backend_spring_boot_tech_it_easy_controller.repositories.RemoteControllerRepository;
import com.novi.backend_spring_boot_tech_it_easy_controller.repositories.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RemoteControllerService {

    private final RemoteControllerRepository remoteControllerRepository;
    private final TelevisionRepository televisionRepository;

    @Autowired
    public RemoteControllerService(RemoteControllerRepository remoteControllerRepository, TelevisionRepository televisionRepository) {
        this.remoteControllerRepository = remoteControllerRepository;
        this.televisionRepository = televisionRepository;
    }

    public void linkRemoteControllerToTelevision(Long televisionId, Long remoteControllerId) {
        Television television = televisionRepository.findById(televisionId)
                .orElseThrow(() -> new RuntimeException("Television not found"));
        RemoteController remoteController = remoteControllerRepository.findById(remoteControllerId)
                .orElseThrow(() -> new RuntimeException("RemoteController not found"));

        television.setRemoteController(remoteController);

        televisionRepository.save(television);
    }

    public List<RemoteControllerDto> getAllRemoteControllers() {
        List<RemoteController> remoteControllersList = remoteControllerRepository.findAll();
        List<RemoteControllerDto> remoteControllerDtoList = new ArrayList<>();

        for (RemoteController remoteController : remoteControllersList) {
            RemoteControllerDto remoteControllerDto = convertToDto(remoteController);
            remoteControllerDtoList.add(remoteControllerDto);
        }

        return remoteControllerDtoList;
    }

    public RemoteControllerDto getRemoteControllerById(Long id) {
        RemoteController remoteController = remoteControllerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RemoteController not found"));
        return convertToDto(remoteController);
    }

    public RemoteControllerDto createRemoteController(RemoteControllerInputDto remoteControllerInputDto) {
        RemoteController remoteController = new RemoteController();
        remoteController.setName(remoteControllerInputDto.getName());
        remoteController.setBrand(remoteControllerInputDto.getBrand());
        remoteController.setPrice(remoteControllerInputDto.getPrice());

        remoteController = remoteControllerRepository.save(remoteController);
        return convertToDto(remoteController);
    }

    public RemoteControllerDto updateRemoteController(Long id, RemoteControllerDto remoteControllerInputDto) {
        RemoteController remoteController = remoteControllerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RemoteController not found"));

        remoteController.setName(remoteControllerInputDto.getName());
        remoteController.setBrand(remoteControllerInputDto.getBrand());
        remoteController.setPrice(remoteControllerInputDto.getPrice());

        RemoteController updatedRemoteController = remoteControllerRepository.save(remoteController);
        return convertToDto(updatedRemoteController);
    }

    public void deleteRemoteController(Long id) {
        if (!remoteControllerRepository.existsById(id)) {
            throw new RuntimeException("RemoteController not found");
        }
        remoteControllerRepository.deleteById(id);
    }

    private RemoteControllerDto convertToDto(RemoteController remoteController) {
        RemoteControllerDto dto = new RemoteControllerDto();
        dto.setId(remoteController.getId());
        dto.setName(remoteController.getName());
        dto.setBrand(remoteController.getBrand());
        dto.setPrice(remoteController.getPrice());
        return dto;
    }
}
