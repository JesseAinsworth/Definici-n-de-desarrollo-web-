package edu.utvt.evaluacion.data.projections;

import edu.utvt.evaluacion.data.enums.Rating;
import java.util.List;

public interface AlumnoEvaluacionView {
    Long getId();

    String getNombre();

    String getApellidos();

    String getCorreo();

    List<EvaluacionInfo> getEvaluaciones();


    interface EvaluacionInfo {
        Long getId();

        Rating getRating();

        MaestroInfo getMaestro();

        interface MaestroInfo {
            Long getId();

            String getNombre();

            String getApellidos();
        }
    }
}
