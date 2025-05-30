package edu.utvt.evaluacion.controllers;

import edu.utvt.evaluacion.data.entities.Maestro;
import edu.utvt.evaluacion.data.service.MaestroService;
import edu.utvt.evaluacion.dto.request.MaestroRequest;
import edu.utvt.evaluacion.dto.response.MaestroResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/maestros")
class MaestroController {

    @Autowired
    private MaestroService maestroService;

    @PostMapping
    public ResponseEntity<Maestro> save(@RequestBody Maestro maestro) {
        return ResponseEntity.status(HttpStatus.CREATED).body(maestroService.save(maestro));
    }

    @PostMapping("/dto")
    public ResponseEntity<Maestro> saveRequest(@RequestBody MaestroRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(maestroService.save(request));
    }

    @GetMapping("/dto/{id}")
    public ResponseEntity<MaestroResponse> findById (@PathVariable Long id) {
        return ResponseEntity.ok(maestroService.findById(id));
    }
}
