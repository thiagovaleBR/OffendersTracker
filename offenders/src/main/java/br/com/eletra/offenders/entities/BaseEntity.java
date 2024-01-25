package br.com.eletra.offenders.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.UUID;
@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    protected UUID id;
    protected String createdBy;
    protected String updatedBy;
    protected ZonedDateTime createdAt;
    protected ZonedDateTime updatedAt;

    @PrePersist
    private void onCreate() {
        if (id == null) {
            id = UUID.randomUUID();
        }
        createdAt = updatedAt = ZonedDateTime.now();
        createdBy = updatedBy = "Thiago.andré";
    }
    @PreUpdate
    private void onUpdate() {
        updatedAt = ZonedDateTime.now();
        updatedBy = "Thiago.andré";
    }

}
