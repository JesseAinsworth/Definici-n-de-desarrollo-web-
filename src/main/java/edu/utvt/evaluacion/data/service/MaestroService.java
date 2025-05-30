package edu.utvt.evaluacion.data.service;

import edu.utvt.evaluacion.data.entities.Maestro;
import edu.utvt.evaluacion.dto.request.MaestroRequest;
import edu.utvt.evaluacion.dto.response.MaestroResponse;

public interface MaestroService {

    Maestro save(Maestro maestro);

    Maestro save(MaestroRequest maestro);

    MaestroResponse findById (Long id);


}
