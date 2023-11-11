package com.devsu.userservice.controller;

import com.devsu.userservice.converter.ClienteConverter;
import com.devsu.userservice.dto.ClienteDTO;
import com.devsu.userservice.dto.PersonaDTO;
import com.devsu.userservice.entity.Cliente;
import com.devsu.userservice.entity.Persona;
import com.devsu.userservice.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
@Slf4j
public class ClienteController {

    private final ClienteService service;
    private final ClienteConverter converter;

    @PostMapping
    public ResponseEntity<ClienteDTO> create(@RequestBody ClienteDTO clienteDTO, UriComponentsBuilder builder){
        log.info("Se ingresa al metodo create en el ClienteController");
        Cliente cliente = converter.toEntity(clienteDTO);


        Cliente clienteCreated = service.create(cliente);

        UriComponents uriComponents = builder.path("/clientes/{id}").buildAndExpand(clienteCreated.getPersonaId());

        ClienteDTO clienteCreatedDto = converter.toDto(clienteCreated);

        return ResponseEntity.created(uriComponents.toUri()).body(clienteCreatedDto);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO, UriComponentsBuilder builder){
        log.info("Se ingresa al metodo update en el ClienteController");

        Cliente clienteUpdated = service.update(clienteDTO, id);

        ClienteDTO clienteUpdatedDTO = converter.toDto(clienteUpdated);

        return new ResponseEntity<>(clienteUpdatedDTO,HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ClienteDTO> patch(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO, UriComponentsBuilder builder){
        log.info("Se ingresa al metodo patch en el ClienteController");

        return null;
    }
}
