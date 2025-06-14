package edu.utvt.evaluacion.controllers;


import edu.utvt.evaluacion.data.entities.Evaluacion;
import edu.utvt.evaluacion.data.service.EvaluacionService;
import edu.utvt.evaluacion.dto.request.EvaluacionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/evaluaciones")
public class EvaluacionController {

    @Autowired
    private EvaluacionService evaluacionService;

    @PutMapping
    private ResponseEntity<Evaluacion> save(@RequestBody EvaluacionRequest request) {
        return ResponseEntity.created(null).body(evaluacionService.save(request));
    }
}
