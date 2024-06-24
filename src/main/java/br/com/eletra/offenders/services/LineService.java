package br.com.eletra.offenders.services;

import br.com.eletra.offenders.entities.LineEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LineService {

    List<LineEntity> findAll();

    Optional<LineEntity> findById(UUID id);
}
