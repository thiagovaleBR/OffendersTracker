package br.com.eletra.offenders.controllers;

import br.com.eletra.offenders.dtos.area.AreaDto;
import br.com.eletra.offenders.services.AreaService;
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
@RequestMapping("/areas")
@RequiredArgsConstructor
public class AreaController {

    private final AreaService areaService;
    @GetMapping
    public ResponseEntity<List<AreaDto>> getAllAreas() {
        return ResponseEntity.status(HttpStatus.OK).body(areaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AreaDto> getAreaById(@PathVariable UUID id) {
        var area = areaService.findById(id);
        return area.map(value -> ResponseEntity.status(HttpStatus.OK).body(value))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }
}
