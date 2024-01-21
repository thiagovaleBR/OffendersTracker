package br.com.eletra.offenders.repositories;

import br.com.eletra.offenders.entities.LineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LineRepository extends JpaRepository<LineEntity, UUID> {
}
