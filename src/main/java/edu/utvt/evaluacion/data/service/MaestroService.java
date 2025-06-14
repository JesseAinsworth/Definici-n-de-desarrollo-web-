package edu.utvt.evaluacion.data.service;

import edu.utvt.evaluacion.data.entities.Maestro;
import edu.utvt.evaluacion.data.projections.MaestroEvaluacionView;
import edu.utvt.evaluacion.data.projections.MaestroSimpleView;
import edu.utvt.evaluacion.dto.request.MaestroRequest;
import edu.utvt.evaluacion.dto.response.MaestroResponse;
import org.springframework.data.domain.Page;


import java.util.List;
import java.util.Optional;

public interface MaestroService {

    Maestro save(Maestro maestro);

    Maestro save(MaestroRequest maestro);

    MaestroResponse findById(Long id);

    List<MaestroResponse> findAllByNombreContainsIgnoreCase(String nombre);

    Page<MaestroResponse> findByApellidosContainsIgnoreCase(String apellidos, int page, int size);

    Optional<MaestroSimpleView> findViewById(Long id);

    Optional<MaestroEvaluacionView> getMaestroEvaluacionById(Long id);
}
