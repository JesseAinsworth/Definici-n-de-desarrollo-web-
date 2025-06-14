package edu.utvt.evaluacion.data.service.impl;

import edu.utvt.evaluacion.data.entities.Alumno;
import edu.utvt.evaluacion.data.repositories.AlumnoRepository;
import edu.utvt.evaluacion.data.service.AlumnoService;
import edu.utvt.evaluacion.dto.mappers.AlumnoMapper;
import edu.utvt.evaluacion.dto.request.AlumnoRequest;
import edu.utvt.evaluacion.dto.response.AlumnoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoRepository alumnoRepository;
    private final AlumnoMapper alumnoMapper;

    @Override
    public AlumnoResponse crearAlumno(AlumnoRequest alumnoRequest) {
        Alumno alumno = alumnoMapper.toAlumno(alumnoRequest);
        return alumnoMapper.toAlumnoResponse(alumnoRepository.save(alumno));
    }

    @Override
    public List<AlumnoResponse> obtenerAlumnos() {
        return alumnoRepository.findAll()
                .stream()
                .map(alumnoMapper::toAlumnoResponse)
                .collect(Collectors.toList());
    }
}
