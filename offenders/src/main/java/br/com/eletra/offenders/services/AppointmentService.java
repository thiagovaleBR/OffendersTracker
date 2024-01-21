package br.com.eletra.offenders.services;

import br.com.eletra.offenders.dtos.appointment.AppointmentDto;
import br.com.eletra.offenders.dtos.appointment.CreateAppointmentDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AppointmentService {
    List<AppointmentDto> findAll();

    Optional<AppointmentDto> findById(UUID id);

    AppointmentDto create(CreateAppointmentDto createAppointmentDto);

    List<AppointmentDto> bulkCreate(List<CreateAppointmentDto> createAppointmentDto);
}
