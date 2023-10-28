package com.devsu.userservice.service;

import com.devsu.userservice.entity.Cliente;
import com.devsu.userservice.repository.IClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteService {


    private final IClienteRepository repository;

    public Cliente create(){
        return null;
    }

    public Long edit(Long id){
        return 1L;
    }

    public void update(Long id){

    }

    public void delete(){

    }
}
