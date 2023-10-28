package com.devsu.userservice.converter;

import com.devsu.userservice.dto.PersonaDTO;
import com.devsu.userservice.entity.Persona;
import org.springframework.stereotype.Component;

@Component
public class PersonaConverter implements IConverter<Persona, PersonaDTO>{
    @Override
    public Persona toEntity(PersonaDTO dto) {
        return Persona.builder().build();
    }

    @Override
    public PersonaDTO toDto(Persona entity) {
        return PersonaDTO.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .genero(entity.getGenero())
                .edad(entity.getEdad())
                .direccion(entity.getDireccion())
                .telefono(entity.getTelefono())
                .build();
    }
}
