package edu.utvt.evaluacion.dto.request;

import edu.utvt.evaluacion.data.enums.TipoMaestro;
import edu.utvt.evaluacion.utils.MensajesError;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;
import java.time.LocalDate;

public record MaestroRequest(
        @NotBlank(message = MensajesError.NOMBRE_REQUERIDO) String nombre,
        @NotBlank(message = MensajesError.APELLIDOS_REQUERIDO) String apellidos,
        @NotBlank(message = MensajesError.CORREO_REQUERIDO) String correo,
        @NotBlank(message = MensajesError.TIPO_MAESTRO_REQUERIDO) TipoMaestro tipo,
        @NotBlank(message = MensajesError.FECHA_NACIMIENTO_ANTERIOR_FECHA_ACTUAL) LocalDate fechaNacimiento
) implements Serializable {
}
