package br.com.eletra.offenders.controllers;

import br.com.eletra.offenders.repositories.LineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LineController {

    @Autowired
    private LineRepository lineRepository;
}
