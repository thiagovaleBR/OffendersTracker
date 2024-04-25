package br.com.eletra.offenders.services;

import br.com.eletra.offenders.dtos.area.AreaDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AreaService  {

    List<AreaDto> findAll();

    Optional<AreaDto> findById(UUID id);
}
