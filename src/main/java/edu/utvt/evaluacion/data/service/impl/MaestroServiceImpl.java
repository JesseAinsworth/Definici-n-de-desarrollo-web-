package edu.utvt.evaluacion.data.service.impl;

import edu.utvt.evaluacion.data.entities.Maestro;
import edu.utvt.evaluacion.data.repositories.MaestroRepository;
import edu.utvt.evaluacion.data.service.MaestroService;
import edu.utvt.evaluacion.dto.mappers.MaestroMapper;
import edu.utvt.evaluacion.dto.request.MaestroRequest;
import edu.utvt.evaluacion.dto.response.MaestroResponse;
import edu.utvt.evaluacion.utils.MensajesError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@Transactional
public class MaestroServiceImpl implements MaestroService {


    @Autowired
    private MaestroRepository maestroRepository;

    @Transactional(readOnly = false)
    @Override
    public Maestro save(Maestro maestro) {
        return this.maestroRepository.save(maestro);
    }

    @Override
    public Maestro save(MaestroRequest maestro) {
        return this.maestroRepository.save(MaestroMapper.toEntity(maestro));
    }

    @Override
    public MaestroResponse findById(Long id) {
        return this.maestroRepository.findById(id).map(MaestroMapper::toResponse).orElseThrow(() -> new NoSuchElementException(MensajesError.NO_ENCONTRADO));
    }

}
