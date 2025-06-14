package edu.utvt.evaluacion.data.projections;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.sql.Timestamp;

public interface AlumnoSimpleView {
    Long getId();

    String getNombre();

    String getApellidos();

    String getMatricula();

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    Timestamp getCreatedAt();
}
