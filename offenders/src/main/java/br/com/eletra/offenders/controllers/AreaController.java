package br.com.eletra.offenders.controllers;

import br.com.eletra.offenders.repositories.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AreaController {

    @Autowired
    private AreaRepository areaRepository;
}
