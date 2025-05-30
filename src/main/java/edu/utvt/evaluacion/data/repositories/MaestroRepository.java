package edu.utvt.evaluacion.data.repositories;

import edu.utvt.evaluacion.data.entities.Maestro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaestroRepository extends JpaRepository<Maestro, Long> {
}