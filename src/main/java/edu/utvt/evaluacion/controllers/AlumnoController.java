package edu.utvt.evaluacion.controllers;

import edu.utvt.evaluacion.data.service.AlumnoService;
import edu.utvt.evaluacion.dto.request.AlumnoRequest;
import edu.utvt.evaluacion.dto.response.AlumnoResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
@RequiredArgsConstructor
public class AlumnoController {

    private final AlumnoService alumnoService;

    @PostMapping
    public AlumnoResponse crearAlumno(@RequestBody @Valid AlumnoRequest alumnoRequest) {
        return alumnoService.crearAlumno(alumnoRequest);
    }

    @GetMapping
    public List<AlumnoResponse> obtenerAlumnos() {
        return alumnoService.obtenerAlumnos();
    }
}
