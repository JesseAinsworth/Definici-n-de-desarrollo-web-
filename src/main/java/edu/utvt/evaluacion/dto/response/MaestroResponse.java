package edu.utvt.evaluacion.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.utvt.evaluacion.data.enums.TipoMaestro;
import edu.utvt.evaluacion.utils.MensajesError;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.Period;

public record MaestroResponse(
        Long id,
        String Nombre,
        String apellidos,
        TipoMaestro tipo,
        String correo,
        @JsonFormat(pattern = "dd/MM/YYYY")
        LocalDate fechaNacimiento,
        @JsonProperty("fechaCreacion")
        @JsonFormat(pattern = "dd/MM/YYYY HH:mm:ss")
        Timestamp createdAt) implements Serializable {

    public Integer getEdad(){

        LocalDate fechaActual = LocalDate.now();

        if (fechaNacimiento != null) {
            return Period.between(fechaNacimiento, fechaActual).getYears();
        } else {
            throw new IllegalArgumentException(MensajesError.FECHA_NACIMIENTO_REQUERIDO);
        }
    }
}
