package edu.utvt.evaluacion.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.utvt.evaluacion.data.enums.TipoMaestro;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "te_maestros")
public class Maestro {

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

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoMaestro tipo;

    @Column(nullable = false)
    @Past(message = "La fecha de nacimiento debe ser un valor anterior a la fecha actual")
    private LocalDate fechaNacimiento;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Timestamp createdAt;

    @JsonIgnore
    @OneToMany(mappedBy = "maestro", fetch = FetchType.EAGER)
    private List<Evaluacion> evaluaciones;
}
