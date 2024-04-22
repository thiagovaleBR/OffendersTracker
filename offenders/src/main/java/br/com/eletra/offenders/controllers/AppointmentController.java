package br.com.eletra.offenders.controllers;

import br.com.eletra.offenders.dtos.appointment.AppointmentDto;
import br.com.eletra.offenders.dtos.appointment.CreateAppointmentDto;
import br.com.eletra.offenders.services.AppointmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
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
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }

    @GetMapping("/line-date")
    public ResponseEntity<List<AppointmentDto>> getAppointmentsByLineAndDate(@RequestParam UUID lineId, @RequestParam LocalDate date) {
        return ResponseEntity.status(HttpStatus.OK).body(appointmentService.findByLineAndDate(lineId, date));
    }

    @GetMapping("/date")
    public ResponseEntity<List<AppointmentDto>> getAppointmentsByDate(@RequestParam LocalDate date) {
        return ResponseEntity.status(HttpStatus.OK).body(appointmentService.findByDate(date));
    }



    @PostMapping
    public ResponseEntity<List<AppointmentDto>> createAppointment(@RequestBody @Valid List<CreateAppointmentDto> createAppointmentDtoList) {
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentService.create(createAppointmentDtoList));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppointmentDto> update(@PathVariable UUID id, @RequestBody @Valid CreateAppointmentDto createAppointmentDto) {
        Optional<AppointmentDto> appointment = appointmentService.findById(id);
        if (appointment.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(appointmentService.update(id, createAppointmentDto));
    }
}
