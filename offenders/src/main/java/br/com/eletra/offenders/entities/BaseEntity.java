package br.com.eletra.offenders.entities;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    protected UUID id;
    protected String createdBy;
    protected String updatedBy;
    protected String createdAt;
    protected String updatedAt;
}
