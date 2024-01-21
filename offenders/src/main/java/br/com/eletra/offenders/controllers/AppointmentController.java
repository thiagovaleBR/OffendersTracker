package br.com.eletra.offenders.controllers;

import br.com.eletra.offenders.dtos.CreateAppointmentDto;
import br.com.eletra.offenders.entities.AppointmentEntity;
import br.com.eletra.offenders.services.AppointmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @GetMapping
    public ResponseEntity<List<AppointmentEntity>> getAllAppointments() {
        return ResponseEntity.status(HttpStatus.OK).body(appointmentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentEntity> getAppointmentById(@PathVariable UUID id) {
        var appointment = appointmentService.findById(id);
        return appointment.map(value -> ResponseEntity.status(HttpStatus.OK).body(value))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<AppointmentEntity> createAppointment(@RequestBody CreateAppointmentDto createAppointmentDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentService.create(createAppointmentDto));
    }
}
