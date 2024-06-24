package br.com.eletra.offenders.dtos.appointment;

import br.com.eletra.offenders.dtos.common.IdAndNameDto;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;
@Data
public class AppointmentDto {
    private UUID id;
    private LocalDate date;
    private IdAndNameDto line;
    private IdAndNameDto offender;
    private LocalTime startTime;
    private LocalTime endTime;
    private String description;
    private Long ticketId;
    private String appointer;
}
