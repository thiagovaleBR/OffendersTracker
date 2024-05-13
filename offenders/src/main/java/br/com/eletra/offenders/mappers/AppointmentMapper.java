package br.com.eletra.offenders.mappers;

import br.com.eletra.offenders.dtos.appointment.AppointmentDto;
import br.com.eletra.offenders.dtos.appointment.CreateAppointmentDto;
import br.com.eletra.offenders.entities.AppointmentEntity;
import br.com.eletra.offenders.entities.AreaEntity;
import br.com.eletra.offenders.entities.LineEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class AppointmentMapper {

    public abstract AppointmentDto toAppointmentDto(AppointmentEntity appointmentEntity);

    public abstract List<AppointmentDto> toAppointmentDtoList(List<AppointmentEntity> appointmentEntityList);


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
