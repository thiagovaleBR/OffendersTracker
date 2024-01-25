package br.com.eletra.offenders.dtos.appointment;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Data
public class CreateAppointmentDto  {
    @NotNull
    private LocalDate date;
    @NotNull
    private UUID lineId;
    @NotNull
    private UUID offenderId;
    @NotNull
    private LocalTime startTime;
    @NotNull
    private LocalTime endTime;
    @NotNull
    private String description;
    private Long ticketId;
    @NotNull
    private String appointer;
}
