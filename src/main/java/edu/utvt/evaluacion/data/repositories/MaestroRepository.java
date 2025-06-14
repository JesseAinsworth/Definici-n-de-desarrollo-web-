package edu.utvt.evaluacion.data.repositories;

import edu.utvt.evaluacion.data.entities.Maestro;
import edu.utvt.evaluacion.data.projections.MaestroEvaluacionView;
import edu.utvt.evaluacion.data.projections.MaestroSimpleView;
import jakarta.validation.constraints.NotBlank;
import lombok.Value;
import org.springframework.data.domain.Limit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MaestroRepository extends JpaRepository<Maestro, Long> {


    // Query methods and property expression: Consultas Derivadas por el Nombre del Metodo

    List<Maestro> findByNombreContainsIgnoreCase(String nombre);

    Page<Maestro> findByApellidosContainsIgnoreCase(String apellidos, Pageable pageable);

    // Query (Consultas JPQL o Nativas)

    @Query(value = "SELECT m.id as id, m.nombre as nombre, m.apellidos as apellidos, m.createdAt as createdAt FROM Maestro m WHERE m.id = :id")
    Optional<MaestroSimpleView> findByMaestroViewById(Long id);

    @Query(value = "SELECT m FROM Maestro m LEFT JOIN FETCH m.evaluaciones e LEFT JOIN FETCH e.alumno WHERE m.id = :id")
    Optional<MaestroEvaluacionView> findByMaestroEvaluacionViewById(Long id);

}