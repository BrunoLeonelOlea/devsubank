package com.devsu.userservice.repository;

import com.devsu.userservice.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonaRepository extends JpaRepository<Persona, Long> {
}
