package edu.utvt.evaluacion.data.service;

import edu.utvt.evaluacion.dto.request.AlumnoRequest;
import edu.utvt.evaluacion.dto.response.AlumnoResponse;

import java.util.List;

public interface AlumnoService {
    AlumnoResponse crearAlumno(AlumnoRequest alumnoRequest);
    List<AlumnoResponse> obtenerAlumnos();
}
