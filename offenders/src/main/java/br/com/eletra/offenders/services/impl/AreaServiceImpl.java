package br.com.eletra.offenders.services.impl;

import br.com.eletra.offenders.dtos.area.AreaDto;
import br.com.eletra.offenders.mappers.AreaMapper;
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
    private final AreaMapper areaMapper;


    public List<AreaDto> findAll() {
        return areaRepository.findAll().stream().map(areaMapper::toAreaDto).toList();
    }

    public Optional<AreaDto> findById(UUID id) {
        return areaRepository.findById(id).map(areaMapper::toAreaDto);
    }
}
