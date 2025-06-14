package edu.utvt.evaluacion.dto.response;

import lombok.Data;

@Data
public class AlumnoResponse {
    private Long id;
    private String nombre;
    private String apellidos;
    private String correo;
}
