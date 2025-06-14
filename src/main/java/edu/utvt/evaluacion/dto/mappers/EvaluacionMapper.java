package edu.utvt.evaluacion.dto.mappers;

import edu.utvt.evaluacion.data.entities.Evaluacion;
import edu.utvt.evaluacion.dto.request.EvaluacionRequest;

public class EvaluacionMapper {

    public static Evaluacion toEntity(EvaluacionRequest request) {
        Evaluacion evaluacion = new Evaluacion();
        evaluacion.setRating(request.rating());
        return evaluacion;
    }
}
