package edu.utvt.evaluacion.data.repositories;

import edu.utvt.evaluacion.data.entities.Evaluacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluacionRepository extends JpaRepository<Evaluacion, Long> {
}