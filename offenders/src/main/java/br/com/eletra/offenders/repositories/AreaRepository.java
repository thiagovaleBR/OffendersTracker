package br.com.eletra.offenders.repositories;

import br.com.eletra.offenders.entities.AreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AreaRepository extends JpaRepository<AreaEntity, UUID> {
}
