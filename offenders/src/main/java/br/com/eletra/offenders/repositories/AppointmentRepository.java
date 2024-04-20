package br.com.eletra.offenders.repositories;

import br.com.eletra.offenders.entities.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity, UUID> {
    List<AppointmentEntity> findByLineIdAndDate(UUID lineId, LocalDate date);

    List<AppointmentEntity> findByDate(LocalDate date);
}
