package com.parcial.web.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.parcial.web.dto.CelularDTO;
import com.parcial.web.entities.Celular;
import com.parcial.web.repositories.CelularRepository;


@Service
public class CelularService {
    CelularRepository celularRepository;
    ModelMapper modelMapper;

    public CelularService(CelularRepository celularRepository, ModelMapper modelMapper){
        this.celularRepository = celularRepository;
        this.modelMapper = modelMapper;
    }

    //GET Celular
    public CelularDTO getCelular(Long id){
        Optional<Celular> optionalCelular = celularRepository.findById(id);
        if(!optionalCelular.isPresent()){
            throw new RuntimeException("Celular no encontrado");
        }
        return modelMapper.map(optionalCelular.get(), CelularDTO.class);
    }

    //GET ALL Celulares
    public List<CelularDTO> getAllCelulares(){
        List<Celular> celularList = (List<Celular>) celularRepository.findAll();
        List<CelularDTO> celularDTOList = celularList.stream()
                .map(celular -> modelMapper.map(celular, CelularDTO.class))
                .toList();
        return celularDTOList;
    }

    //CREATE Celular
    public CelularDTO createCelular(CelularDTO celularDTO){
        Celular celular = modelMapper.map(celularDTO, Celular.class);
        celular = celularRepository.save(celular);
        return modelMapper.map(celular, CelularDTO.class);
    }

    //UPDATE Celular
    public CelularDTO updateCelular(CelularDTO celularDTO){
        if(!celularRepository.existsById(celularDTO.getId())){
            throw new RuntimeException("Celular no encontrado");
        }
        Celular celular = modelMapper.map(celularDTO, Celular.class);
        celular = celularRepository.save(celular);
        return modelMapper.map(celular, CelularDTO.class);
    }

    //DELETE Celular
    public void deleteCelular(Long id){
        if(!celularRepository.existsById(id)){
            throw new RuntimeException("Celular no encontrado");
        }
        celularRepository.deleteById(id);
    }


}
