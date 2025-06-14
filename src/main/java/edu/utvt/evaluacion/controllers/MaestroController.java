package edu.utvt.evaluacion.controllers;

import edu.utvt.evaluacion.data.entities.Maestro;
import edu.utvt.evaluacion.data.projections.MaestroEvaluacionView;
import edu.utvt.evaluacion.data.projections.MaestroSimpleView;
import edu.utvt.evaluacion.data.service.MaestroService;
import edu.utvt.evaluacion.dto.request.MaestroRequest;
import edu.utvt.evaluacion.dto.response.MaestroResponse;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<MaestroResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(maestroService.findById(id));
    }

    @GetMapping("/query_methods/nombre/{nombre}")
    public ResponseEntity<List<MaestroResponse>> findByNombreContainsIgnoreCase(@PathVariable String nombre) {
        return ResponseEntity.ok(maestroService.findAllByNombreContainsIgnoreCase(nombre));
    }

    @GetMapping("/query_methods/apellidos")
    public ResponseEntity<Page<MaestroResponse>> findByApellidosContainsIgnoreCase(
            @RequestParam String apellidos,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size) {
        return ResponseEntity.ok(maestroService.findByApellidosContainsIgnoreCase(apellidos, page, size));
    }

    @GetMapping("/projections/view/simple/{id}")
    public ResponseEntity<MaestroSimpleView> findViewById(@PathVariable Long id) {
        return ResponseEntity.of(maestroService.findViewById(id));
    }

    @GetMapping("/projections/view/evaluacion/{id}")
    public ResponseEntity<MaestroEvaluacionView> findMaestroEvaluacionViewById(@PathVariable Long id) {
        return ResponseEntity.of(maestroService.getMaestroEvaluacionById(id));
    }
}
