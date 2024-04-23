package br.com.eletra.offenders.services.impl;

import br.com.eletra.offenders.entities.AreaEntity;
import br.com.eletra.offenders.repositories.AreaRepository;
import br.com.eletra.offenders.services.AreaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@RequiredArgsConstructor
@Service
public class AreaServiceImpl implements AreaService {

    private final AreaRepository areaRepository;
    @Override
    public List<AreaEntity> findAll() {
        return areaRepository.findAll();
    }

    @Override
    public Optional<AreaEntity> findById(UUID id) {
        return areaRepository.findById(id);
    }
}
