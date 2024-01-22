package br.com.eletra.offenders.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "appointments")
public class AppointmentEntity extends BaseEntity{

    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "line_id")
    private LineEntity line;
    @ManyToOne
    @JoinColumn(name = "offender_id")
    private AreaEntity offender;
    private LocalTime startTime;
    private LocalTime endTime;
    private String description;
    private Long ticketId;
    private String appointer;

}
