package br.com.eletra.offenders.services.impl;

import br.com.eletra.offenders.dtos.CreateAppointmentDto;
import br.com.eletra.offenders.entities.AppointmentEntity;
import br.com.eletra.offenders.entities.AreaEntity;
import br.com.eletra.offenders.entities.LineEntity;
import br.com.eletra.offenders.repositories.AppointmentRepository;
import br.com.eletra.offenders.repositories.AreaRepository;
import br.com.eletra.offenders.repositories.LineRepository;
import br.com.eletra.offenders.services.AppointmentService;
import jakarta.persistence.EntityNotFoundException;
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

        var line = getLineEntity(createAppointmentDto);
        var offender = getAreaEntity(createAppointmentDto);

        AppointmentEntity appointment = AppointmentEntity.builder()
                .date(createAppointmentDto.getDate())
                .line(line)
                .offender(offender)
                .startTime(createAppointmentDto.getStartTime())
                .endTime(createAppointmentDto.getEndTime())
                .description(createAppointmentDto.getDescription())
                .ticketId(createAppointmentDto.getTicketId())
                .appointer(createAppointmentDto.getAppointer())
                .build();

        return appointmentRepository.save(appointment);
    }

    private AreaEntity getAreaEntity(CreateAppointmentDto createAppointmentDto) {
        return areaRepository.findById(createAppointmentDto.getOffenderId())
                .orElseThrow(() -> new EntityNotFoundException("Offender not found with ID: " +
                        createAppointmentDto.getOffenderId()));
    }

    private LineEntity getLineEntity(CreateAppointmentDto createAppointmentDto) {
        return lineRepository.findById(createAppointmentDto.getLineId())
                .orElseThrow(() -> new EntityNotFoundException("Line not found with ID: " +
                        createAppointmentDto.getLineId()));
    }
}
