package br.com.eletra.offenders.services;

import br.com.eletra.offenders.dtos.appointment.AppointmentDto;
import br.com.eletra.offenders.dtos.appointment.CreateAppointmentDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AppointmentService {
    List<AppointmentDto> findAll();

    Optional<AppointmentDto> findById(UUID id);

    List<AppointmentDto> create(List<CreateAppointmentDto> createAppointmentDto);

    AppointmentDto update(UUID id, CreateAppointmentDto createAppointmentDto);

    List<AppointmentDto> findByLineAndDate(UUID lineId, LocalDate date);

    List<AppointmentDto> findByDate(LocalDate date);

    AppointmentDto delete(UUID id);
}
