package br.com.eletra.offenders.services.impl;

import br.com.eletra.offenders.dtos.appointment.AppointmentDto;
import br.com.eletra.offenders.dtos.appointment.CreateAppointmentDto;
import br.com.eletra.offenders.mappers.AppointmentMapper;
import br.com.eletra.offenders.repositories.AppointmentRepository;
import br.com.eletra.offenders.repositories.AreaRepository;
import br.com.eletra.offenders.repositories.LineRepository;
import br.com.eletra.offenders.services.AppointmentService;
import jakarta.transaction.Transactional;
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
    private final AppointmentMapper appointmentMapper;

    public List<AppointmentDto> findAll() {
        return appointmentRepository.findAll().stream().map(appointmentMapper::toAppointmentDto).toList();
    }

    public Optional<AppointmentDto> findById(UUID id) {
        return appointmentRepository.findById(id).map(appointmentMapper::toAppointmentDto);
    }

    public AppointmentDto create(CreateAppointmentDto createAppointmentDto) {
        var line = lineRepository.findById(createAppointmentDto.getLineId()).orElseThrow();
        var offender = areaRepository.findById(createAppointmentDto.getOffenderId()).orElseThrow();
        var appointment = appointmentMapper.toEntity(createAppointmentDto, line, offender);
        appointmentRepository.save(appointment);
        return appointmentMapper.toAppointmentDto(appointment);
    }
    @Transactional
    public List<AppointmentDto> bulkCreate(List<CreateAppointmentDto> createAppointmentDtoList) {
        return createAppointmentDtoList.stream().map(this::create).toList();
    }
}
