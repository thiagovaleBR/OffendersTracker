package br.com.eletra.offenders.mappers;

import br.com.eletra.offenders.dtos.appointment.AppointmentDto;
import br.com.eletra.offenders.dtos.appointment.CreateAppointmentDto;
import br.com.eletra.offenders.entities.AppointmentEntity;
import br.com.eletra.offenders.entities.AreaEntity;
import br.com.eletra.offenders.entities.LineEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AppointmentMapper {

    private final LineMapper lineMapper;
    private final AreaMapper areaMapper;

    public AppointmentDto toAppointmentDto(AppointmentEntity appointmentEntity) {
        AppointmentDto appointmentDto = new AppointmentDto();
        appointmentDto.setId(appointmentEntity.getId());
        appointmentDto.setDate(appointmentEntity.getDate());
        appointmentDto.setLine(lineMapper.toIdAndNameDto(appointmentEntity.getLine()));
        appointmentDto.setOffender(areaMapper.toIdAndNameDto(appointmentEntity.getOffender()));
        appointmentDto.setStartTime(appointmentEntity.getStartTime());
        appointmentDto.setEndTime(appointmentEntity.getEndTime());
        appointmentDto.setDescription(appointmentEntity.getDescription());
        appointmentDto.setTicketId(appointmentEntity.getTicketId());
        appointmentDto.setAppointer(appointmentEntity.getAppointer());
        return appointmentDto;
    }

    public AppointmentEntity createEntity(CreateAppointmentDto createAppointmentDto, LineEntity line, AreaEntity offender) {
        var appointment = new AppointmentEntity();
        return updateEntity(appointment, createAppointmentDto, line, offender);
    }

    public AppointmentEntity updateEntity (AppointmentEntity appointment, CreateAppointmentDto createAppointmentDto, LineEntity line, AreaEntity offender) {
        appointment.setDate(createAppointmentDto.getDate());
        appointment.setLine(line);
        appointment.setOffender(offender);
        appointment.setStartTime(createAppointmentDto.getStartTime());
        appointment.setEndTime(createAppointmentDto.getEndTime());
        appointment.setDescription(createAppointmentDto.getDescription());
        appointment.setTicketId(createAppointmentDto.getTicketId());
        appointment.setAppointer(createAppointmentDto.getAppointer());
        return appointment;
    }

}
