package edu.utvt.evaluacion.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AlumnoRequest {

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 3, message = "El nombre debe tener al menos 3 caracteres")
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacío")
    @Size(min = 3, message = "El apellido debe tener al menos 3 caracteres")
    private String apellidos;

    @Email(message = "Correo electrónico inválido")
    @NotBlank(message = "El correo no puede estar vacío")
    private String correo;
}
