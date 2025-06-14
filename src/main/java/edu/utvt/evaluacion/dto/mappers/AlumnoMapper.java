package edu.utvt.evaluacion.dto.mappers;

import edu.utvt.evaluacion.data.entities.Alumno;
import edu.utvt.evaluacion.dto.request.AlumnoRequest;
import edu.utvt.evaluacion.dto.response.AlumnoResponse;
import org.springframework.stereotype.Component;

@Component
public class AlumnoMapper {

    public Alumno toAlumno(AlumnoRequest request) {
        Alumno alumno = new Alumno();
        alumno.setNombre(request.getNombre());
        alumno.setApellidos(request.getApellidos());
        alumno.setCorreo(request.getCorreo());
        return alumno;
    }

    public AlumnoResponse toAlumnoResponse(Alumno alumno) {
        AlumnoResponse response = new AlumnoResponse();
        response.setId(alumno.getId());
        response.setNombre(alumno.getNombre());
        response.setApellidos(alumno.getApellidos());
        response.setCorreo(alumno.getCorreo());
        return response;
    }
}
