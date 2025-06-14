package edu.utvt.evaluacion.dto.request;

import edu.utvt.evaluacion.data.enums.Rating;
import edu.utvt.evaluacion.utils.MensajesError;
import jakarta.validation.constraints.NotNull;

public record EvaluacionRequest(
        @NotNull(message = MensajesError.VALOR_REQUERIDO) Long alumnoId,
        @NotNull(message = MensajesError.VALOR_REQUERIDO) Long maestroId,
        @NotNull(message = MensajesError.VALOR_REQUERIDO) Rating rating
) {
}
