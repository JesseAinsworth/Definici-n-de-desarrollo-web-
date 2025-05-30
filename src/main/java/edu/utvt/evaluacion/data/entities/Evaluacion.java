package edu.utvt.evaluacion.data.entities;


import edu.utvt.evaluacion.data.enums.Rating;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tr_evaluaciones", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"maestro_id", "alumno_id"})
})
public class Evaluacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    private Rating rating;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "maestro_id", referencedColumnName = "id")
    private Maestro maestro;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "alumno_id", referencedColumnName = "id")
    private Alumno alumno;
}