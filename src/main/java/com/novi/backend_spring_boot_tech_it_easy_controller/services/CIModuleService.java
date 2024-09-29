package com.novi.backend_spring_boot_tech_it_easy_controller.services;

import com.novi.backend_spring_boot_tech_it_easy_controller.dtos.CIModuleDto;
import com.novi.backend_spring_boot_tech_it_easy_controller.dtos.CIModuleInputDto;
import com.novi.backend_spring_boot_tech_it_easy_controller.models.CIModule;
import com.novi.backend_spring_boot_tech_it_easy_controller.repositories.CIModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CIModuleService {

    private final CIModuleRepository cIModuleRepository;

    @Autowired
    public CIModuleService(CIModuleRepository cIModuleRepository) {
        this.cIModuleRepository = cIModuleRepository;
    }

    public List<CIModuleDto> getAllCIModules() {
        List<CIModule> ciModulesList = cIModuleRepository.findAll();
        List<CIModuleDto> cIModuleDtoList = new ArrayList<>();

        for (CIModule cIModule : ciModulesList) {
            CIModuleDto cIModuleDto = convertToDto(cIModule);
            cIModuleDtoList.add(cIModuleDto);
        }

        return cIModuleDtoList;
    }

    public CIModuleDto getCIModuleById(Long id) {
        CIModule cIModule = cIModuleRepository.findById(id).orElseThrow(() -> new RuntimeException("CIModule not found"));
        return convertToDto(cIModule);
    }

    public CIModuleDto createCIModule(CIModuleInputDto cIModuleInputDto) {
        CIModule cIModule = new CIModule();
        cIModule.setName(cIModuleInputDto.getName());
        cIModule.setPrice(cIModuleInputDto.getPrice());
        cIModule.setBrand(cIModuleInputDto.getBrand());

        cIModule = cIModuleRepository.save(cIModule);
        return convertToDto(cIModule);
    }

    public CIModuleDto updateCIModule(Long id, CIModuleDto cIModuleInputDto) {
        CIModule cIModule = cIModuleRepository.findById(id).orElseThrow(() -> new RuntimeException("CIModule not found"));

        cIModule.setName(cIModuleInputDto.getName());
        cIModule.setPrice(cIModuleInputDto.getPrice());
        cIModule.setBrand(cIModuleInputDto.getBrand());

        CIModule updatedCIModule = cIModuleRepository.save(cIModule);
        return convertToDto(updatedCIModule);
    }

    public void deleteCIModule(Long id) {
        if (!cIModuleRepository.existsById(id)) {
            throw new RuntimeException("CIModule not found");
        }
        cIModuleRepository.deleteById(id);
    }

    private CIModuleDto convertToDto(CIModule cIModule) {
        CIModuleDto dto = new CIModuleDto();
        dto.setId(cIModule.getId());
        dto.setName(cIModule.getName());
        dto.setBrand(cIModule.getBrand());
        dto.setPrice(cIModule.getPrice());
        return dto;
    }

    public List<CIModuleDto> getAllCIModule() {
        List<CIModuleDto> o = null;
        return o;
    }
}
