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

import java.time.LocalDate;
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
        var appointments = appointmentRepository.findAll();
        return appointmentMapper.toAppointmentDtoList(appointments);
    }

    public Optional<AppointmentDto> findById(UUID id) {
        return appointmentRepository.findById(id).map(appointmentMapper::toAppointmentDto);
    }

    public AppointmentDto create(CreateAppointmentDto createAppointmentDto) {
        var line = lineRepository.findById(createAppointmentDto.getLineId()).orElseThrow();
        var offender = areaRepository.findById(createAppointmentDto.getOffenderId()).orElseThrow();
        var appointment = appointmentMapper.createEntity(createAppointmentDto, line, offender);
        appointmentRepository.save(appointment);
        return appointmentMapper.toAppointmentDto(appointment);
    }
    @Transactional
    public List<AppointmentDto> create(List<CreateAppointmentDto> createAppointmentDtoList) {
        return createAppointmentDtoList.stream().map(this::create).toList();
    }

    public AppointmentDto update(UUID id, CreateAppointmentDto createAppointmentDto) {
            var appointment = appointmentRepository.findById(id).orElseThrow();
            var line = lineRepository.findById(createAppointmentDto.getLineId()).orElseThrow();
            var offender = areaRepository.findById(createAppointmentDto.getOffenderId()).orElseThrow();
            appointmentMapper.updateEntity(appointment, createAppointmentDto, line, offender);
            appointmentRepository.save(appointment);
            return appointmentMapper.toAppointmentDto(appointment);
        }
    public List<AppointmentDto> findByLineAndDate(UUID lineId, LocalDate date) {
        var AppointmentsList = appointmentRepository.findByLineIdAndDate(lineId, date);
        return appointmentMapper.toAppointmentDtoList(AppointmentsList);
    }
    public List<AppointmentDto> findByDate(LocalDate date) {
        var AppointmentsList = appointmentRepository.findByDate(date);
        return appointmentMapper.toAppointmentDtoList(AppointmentsList);
    }
}
