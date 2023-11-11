package com.devsu.userservice.converter;

import com.devsu.userservice.dto.ClienteDTO;
import com.devsu.userservice.entity.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteConverter implements IConverter<Cliente, ClienteDTO>{
    @Override
    public Cliente toEntity(ClienteDTO dto) {
        return Cliente.builder()
                .nombre(dto.getNombre())
                .edad(dto.getEdad())
                .genero(dto.getGenero())
                .telefono(dto.getTelefono())
                .identificacion(dto.getIdentificacion())
                .direccion(dto.getDireccion())
                .contrasenia(dto.getContrasenia())
                .estado(dto.isEstado())
                .build();
    }

    @Override
    public ClienteDTO toDto(Cliente entity) {
        return null;
    }

    public Cliente fromEntitytoEntity(Cliente entity) {
        return null;
    }
}
