package br.com.eletra.offenders.services;

import br.com.eletra.offenders.entities.AreaEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AreaService  {

    List<AreaEntity> findAll();

    Optional<AreaEntity> findById(UUID id);
}
