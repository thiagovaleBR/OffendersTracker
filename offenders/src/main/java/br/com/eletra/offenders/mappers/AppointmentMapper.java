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

    public abstract AppointmentEntity updateEntity(AppointmentEntity appointment, CreateAppointmentDto createAppointmentDto, LineEntity line, AreaEntity offender);


}
