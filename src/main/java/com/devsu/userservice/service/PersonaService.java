package com.devsu.userservice.service;

import com.devsu.userservice.entity.Persona;
import com.devsu.userservice.repository.IPersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonaService {

    private final IPersonaRepository repository;
    public Persona create(Persona persona) {
        repository.save(persona);
        return persona;
    }
}
