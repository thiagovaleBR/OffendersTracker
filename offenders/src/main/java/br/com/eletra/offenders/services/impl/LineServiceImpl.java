package br.com.eletra.offenders.services.impl;

import br.com.eletra.offenders.entities.LineEntity;
import br.com.eletra.offenders.repositories.LineRepository;
import br.com.eletra.offenders.services.LineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LineServiceImpl implements LineService {

    private final LineRepository lineRepository;


    @Override
    public List<LineEntity> findAll() {
        return lineRepository.findAll();
    }

    @Override
    public Optional<LineEntity> findById(UUID id) {
        return lineRepository.findById(id);
    }
}
