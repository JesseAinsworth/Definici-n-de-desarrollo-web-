package edu.utvt.evaluacion.data.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "te_alumnos")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "No debe estar vació el nombre")
    @Column(nullable = false, length = 50)
    private String nombre;

    @NotBlank(message = "No debe estar vació los apellidos")
    @Column(nullable = false, length = 100)
    private String apellidos;
    @NotBlank(message = "No debe estar vació el correo")

    @Column(nullable = false, length = 100, unique = true)
    private String correo;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Timestamp createdAt;

    @OneToMany(mappedBy = "alumno", fetch = FetchType.LAZY)
    private List<Evaluacion> evaluaciones;


}
