package com.novi.backend_spring_boot_tech_it_easy_controller.services;

import ch.qos.logback.core.pattern.FormatInfo;
import com.novi.backend_spring_boot_tech_it_easy_controller.dtos.TelevisionDto;
import com.novi.backend_spring_boot_tech_it_easy_controller.dtos.TelevisionInputDto;
import com.novi.backend_spring_boot_tech_it_easy_controller.exceptions.RecordNotFoundException;
import com.novi.backend_spring_boot_tech_it_easy_controller.models.Television;
import com.novi.backend_spring_boot_tech_it_easy_controller.repositories.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<Television> televisionsList = televisionRepository.findAll();
        List<TelevisionDto> televisionDtoList = new ArrayList<>();
        for (Television television: televisionsList
             ) {
            TelevisionDto televisionDto = convertToDto(television);
            televisionDtoList.add(televisionDto);
        }
        return televisionDtoList;

//        return televisionsList.stream()
//                .map(this::convertToDto)

//                .collect(Collectors.toList());
    }

    public TelevisionDto updateTelevision(Long id, TelevisionDto televisionDto) {

        Television television = televisionRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Television not found"));


        television.setName(televisionDto.getName());
        television.setBrand(televisionDto.getBrand());
        television.setPrice(televisionDto.getPrice());


        television = televisionRepository.save(television);


        return convertToDto(television);
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
