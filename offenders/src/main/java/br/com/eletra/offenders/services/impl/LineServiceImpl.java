package br.com.eletra.offenders.services.impl;

import br.com.eletra.offenders.dtos.line.LineDto;
import br.com.eletra.offenders.mappers.LineMapper;
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
    private final LineMapper lineMapper;


    @Override
    public List<LineDto> findAll() {
        var lines = lineRepository.findAll();
        return lineMapper.toLineDtoList(lines);
    }

    @Override
    public Optional<LineDto> findById(UUID id) {
        var line = lineRepository.findById(id);
        return Optional.ofNullable(lineMapper.toLineDto(line));
    }
}
