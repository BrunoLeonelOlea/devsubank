package com.devsu.userservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteDTO {

    private String nombre;
    private String genero;
    private Integer edad;
    private String identificacion;
    private String direccion;
    private String telefono;
    private String contrasenia;
    private boolean estado;
}
