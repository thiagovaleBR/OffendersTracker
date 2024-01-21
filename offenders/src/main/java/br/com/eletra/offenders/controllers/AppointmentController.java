package br.com.eletra.offenders.controllers;

import br.com.eletra.offenders.dtos.appointment.AppointmentDto;
import br.com.eletra.offenders.dtos.appointment.CreateAppointmentDto;
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
    public ResponseEntity<List<AppointmentDto>> getAllAppointments() {
        return ResponseEntity.status(HttpStatus.OK).body(appointmentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDto> getAppointmentById(@PathVariable UUID id) {
        var appointment = appointmentService.findById(id);
        return appointment.map(value -> ResponseEntity.status(HttpStatus.OK).body(value))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<List<AppointmentDto>> createAppointment(@RequestBody @Valid List<CreateAppointmentDto> createAppointmentDtoList) {
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentService.bulkCreate(createAppointmentDtoList));
    }
}
