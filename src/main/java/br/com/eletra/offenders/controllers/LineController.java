package br.com.eletra.offenders.controllers;


import br.com.eletra.offenders.entities.LineEntity;
import br.com.eletra.offenders.services.LineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/lines")
@RequiredArgsConstructor
public class LineController {

    private final LineService lineService;
    @GetMapping
    public ResponseEntity<List<LineEntity>> getAllAreas() {
        return ResponseEntity.status(HttpStatus.OK).body(lineService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LineEntity> getAreaById(@PathVariable UUID id) {
        var line = lineService.findById(id);
        return line.map(value -> ResponseEntity.status(HttpStatus.OK).body(value))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }

}
