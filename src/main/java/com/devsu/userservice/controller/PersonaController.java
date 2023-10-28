package com.devsu.userservice.controller;

import com.devsu.userservice.converter.PersonaConverter;
import com.devsu.userservice.dto.PersonaDTO;
import com.devsu.userservice.entity.Persona;
import com.devsu.userservice.service.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/personas")
@RequiredArgsConstructor
public class PersonaController {

    private final PersonaService service;
    private final PersonaConverter converter;
    @PostMapping
    public ResponseEntity<PersonaDTO> createPersona(@RequestBody PersonaDTO personaDto, UriComponentsBuilder builder){
        Persona persona = converter.toEntity(personaDto);
        Persona personaCreated = service.create(persona);

        UriComponents uriComponents = builder.path("/personas/{id}").buildAndExpand(personaCreated.getId());

        PersonaDTO createdPersonaDTO = converter.toDto(personaCreated);

        return ResponseEntity.created(uriComponents.toUri()).body(createdPersonaDTO);
    }
}
