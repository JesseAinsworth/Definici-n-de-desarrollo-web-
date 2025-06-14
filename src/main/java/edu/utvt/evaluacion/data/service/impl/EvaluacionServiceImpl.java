package edu.utvt.evaluacion.data.service.impl;

import edu.utvt.evaluacion.data.entities.Alumno;
import edu.utvt.evaluacion.data.entities.Evaluacion;
import edu.utvt.evaluacion.data.entities.Maestro;
import edu.utvt.evaluacion.data.repositories.AlumnoRepository;
import edu.utvt.evaluacion.data.repositories.EvaluacionRepository;
import edu.utvt.evaluacion.data.repositories.MaestroRepository;
import edu.utvt.evaluacion.data.service.EvaluacionService;
import edu.utvt.evaluacion.dto.mappers.EvaluacionMapper;
import edu.utvt.evaluacion.dto.request.EvaluacionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@Transactional
public class EvaluacionServiceImpl implements EvaluacionService {

    @Autowired
    private EvaluacionRepository evaluacionRepository;

    @Autowired
    private MaestroRepository maestroRepository;

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Override
    public Evaluacion save(EvaluacionRequest request) {

        Maestro maestro = this.maestroRepository.findById(request.maestroId()).orElseThrow(() -> new NoSuchElementException("Maestro no encontrado"));
        Alumno alumno = this.alumnoRepository.findById(request.alumnoId()).orElseThrow(() -> new NoSuchElementException("Alumno no encontrado"));

        Evaluacion evaluacion = EvaluacionMapper.toEntity(request);
        evaluacion.setMaestro(maestro);
        evaluacion.setAlumno(alumno);

        return this.evaluacionRepository.save(evaluacion);
    }

}
