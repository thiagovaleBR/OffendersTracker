package br.com.eletra.offenders.services.impl;

import br.com.eletra.offenders.dtos.CreateAppointmentDto;
import br.com.eletra.offenders.entities.AppointmentEntity;
import br.com.eletra.offenders.repositories.AppointmentRepository;
import br.com.eletra.offenders.repositories.AreaRepository;
import br.com.eletra.offenders.repositories.LineRepository;
import br.com.eletra.offenders.services.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final LineRepository lineRepository;
    private final AreaRepository areaRepository;

    public List<AppointmentEntity> findAll() {
        return appointmentRepository.findAll();
    }

    public Optional<AppointmentEntity> findById(UUID id) {
        return appointmentRepository.findById(id);
    }

    public AppointmentEntity create(CreateAppointmentDto createAppointmentDto) {
        var appointment = new AppointmentEntity();
        var line = lineRepository.findById(createAppointmentDto.getLineId()).orElseThrow();
        var offender = areaRepository.findById(createAppointmentDto.getOffenderId()).orElseThrow();
        appointment.setDate(createAppointmentDto.getDate());
        appointment.setLine(line);
        appointment.setOffender(offender);
        appointment.setStartTime(createAppointmentDto.getStartTime());
        appointment.setEndTime(createAppointmentDto.getEndTime());
        appointment.setDescription(createAppointmentDto.getDescription());
        appointment.setTicketId(createAppointmentDto.getTicketId());
        appointment.setAppointer(createAppointmentDto.getAppointer());
        return appointmentRepository.save(appointment);
    }
}
