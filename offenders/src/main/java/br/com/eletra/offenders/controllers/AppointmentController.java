package br.com.eletra.offenders.controllers;

import br.com.eletra.offenders.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;
}
