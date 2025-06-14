package edu.utvt.evaluacion.data.projections;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

/**
 * Projection for {@link edu.utvt.evaluacion.data.entities.Maestro}
 */
public interface MaestroSimpleView {
    Long getId();

    String getNombre();

    String getApellidos();

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    Timestamp getCreatedAt();
}