package br.com.eletra.offenders.services;

import br.com.eletra.offenders.dtos.line.LineDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LineService {

    List<LineDto> findAll();

    Optional<LineDto> findById(UUID id);
}
