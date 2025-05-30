package edu.utvt.evaluacion.data.repositories;

import edu.utvt.evaluacion.data.entities.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}