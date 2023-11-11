package com.devsu.userservice.service;

import com.devsu.userservice.converter.ClienteConverter;
import com.devsu.userservice.dto.ClienteDTO;
import com.devsu.userservice.entity.Cliente;
import com.devsu.userservice.exception.ClientNotFoundException;
import com.devsu.userservice.repository.IClienteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClienteService {


    private final IClienteRepository repository;
    private final ClienteConverter converter;
    private final ModelMapper mapper;

    public Cliente create(Cliente cliente){
        log.info("Se llama al metodo create en Service Layer");
        return repository.save(cliente);
    }

    public Long edit(Long id){
        return 1L;
    }

    public Cliente update(ClienteDTO updatedClientDTO, Long id){
        log.info("Se llama al metodo update en Service Layer");
        Cliente cliente = repository.findById(id).orElse(null);
        if(Objects.isNull(cliente)){
            throw new ClientNotFoundException("Cliente con el id: " + id + " no encontrado");
        }
        mapper.map(updatedClientDTO,cliente);
        return repository.save(cliente);
    }

    public void delete(){

    }
}
