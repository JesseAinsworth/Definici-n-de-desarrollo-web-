package edu.utvt.evaluacion.data.projections;

import edu.utvt.evaluacion.data.enums.Rating;

import java.util.List;

/**
 * Projection for {@link edu.utvt.evaluacion.data.entities.Maestro}
 */
public interface MaestroEvaluacionView {
    Long getId();

    String getNombre();

    String getApellidos();

    String getCorreo();

    List<EvaluacionInfo> getEvaluaciones();

    /**
     * Projection for {@link edu.utvt.evaluacion.data.entities.Evaluacion}
     */
    interface EvaluacionInfo {
        Long getId();

        Rating getRating();

        AlumnoInfo getAlumno();

        /**
         * Projection for {@link edu.utvt.evaluacion.data.entities.Alumno}
         */
        interface AlumnoInfo {
            Long getId();

            String getNombre();

            String getApellidos();
        }
    }
}