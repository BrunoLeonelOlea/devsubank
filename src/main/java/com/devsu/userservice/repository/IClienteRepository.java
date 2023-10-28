package com.devsu.userservice.repository;

import com.devsu.userservice.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface IClienteRepository extends CrudRepository<Cliente,Long> {
}
