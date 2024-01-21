package br.com.eletra.offenders.services;

import br.com.eletra.offenders.dtos.CreateAppointmentDto;
import br.com.eletra.offenders.entities.AppointmentEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AppointmentService {
    List<AppointmentEntity> findAll();

    Optional<AppointmentEntity> findById(UUID id);

    AppointmentEntity create(CreateAppointmentDto createAppointmentDto);
}
