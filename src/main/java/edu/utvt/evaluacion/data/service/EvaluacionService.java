package edu.utvt.evaluacion.data.service;

import edu.utvt.evaluacion.data.entities.Evaluacion;
import edu.utvt.evaluacion.dto.request.EvaluacionRequest;

public interface EvaluacionService {

    Evaluacion save(EvaluacionRequest request);
}
