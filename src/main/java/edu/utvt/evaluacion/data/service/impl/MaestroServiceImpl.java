package edu.utvt.evaluacion.data.service.impl;

import edu.utvt.evaluacion.data.entities.Maestro;
import edu.utvt.evaluacion.data.projections.MaestroEvaluacionView;
import edu.utvt.evaluacion.data.projections.MaestroSimpleView;
import edu.utvt.evaluacion.data.repositories.MaestroRepository;
import edu.utvt.evaluacion.data.service.MaestroService;
import edu.utvt.evaluacion.dto.mappers.MaestroMapper;
import edu.utvt.evaluacion.dto.request.MaestroRequest;
import edu.utvt.evaluacion.dto.response.MaestroResponse;
import edu.utvt.evaluacion.utils.MensajesError;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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
        return this.maestroRepository.save(MaestroMapper.toEntity(maestro));}

    @Transactional(readOnly = true)
    @Override
    public MaestroResponse findById(Long id) {
        return this.maestroRepository.findById(id).map(MaestroMapper::toResponse).orElseThrow(() -> new NoSuchElementException(MensajesError.NO_ENCONTRADO));
    }

    @Override
    public List<MaestroResponse> findAllByNombreContainsIgnoreCase(String nombre) {
        return this.maestroRepository.findByNombreContainsIgnoreCase(nombre).stream().map(MaestroMapper::toResponse).toList();
    }

    @Override
    public Page<MaestroResponse> findByApellidosContainsIgnoreCase(String apellidos, int page, int size){

        if (apellidos.isBlank())
            throw new IllegalArgumentException(MensajesError.APELLIDOS_REQUERIDO);

        Pageable pageable = PageRequest.of(page, size, Sort.by("apellidos").ascending());
        return this.maestroRepository.findByApellidosContainsIgnoreCase(apellidos, pageable).map(MaestroMapper::toResponse);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<MaestroSimpleView> findViewById(Long id) {
        return this.maestroRepository.findByMaestroViewById(id);
    }
    @Override
    public Optional<MaestroEvaluacionView> getMaestroEvaluacionById(Long id) {
        return this.maestroRepository.findByMaestroEvaluacionViewById(id);
    }
}