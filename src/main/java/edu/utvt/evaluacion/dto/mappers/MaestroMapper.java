package edu.utvt.evaluacion.dto.mappers;

import edu.utvt.evaluacion.data.entities.Maestro;
import edu.utvt.evaluacion.dto.request.MaestroRequest;
import edu.utvt.evaluacion.dto.response.MaestroResponse;

public class MaestroMapper {

    public static Maestro toEntity(MaestroRequest request) {

        Maestro maestro = new Maestro();
        maestro.setNombre(request.nombre());
        maestro.setApellidos(request.apellidos());
        maestro.setCorreo(request.correo());
        maestro.setTipo(request.tipo());
        maestro.setFechaNacimiento(request.fechaNacimiento());

        return maestro;
    }

    public static MaestroResponse toResponse(Maestro entity) {

        return new MaestroResponse(entity.getId(), entity.getNombre(), entity.getApellidos(),
                entity.getTipo(), entity.getCorreo(), entity.getFechaNacimiento(), entity.getCreatedAt());
    }
}
