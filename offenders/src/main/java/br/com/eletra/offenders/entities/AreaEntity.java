package br.com.eletra.offenders.entities;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "areas")
public class AreaEntity extends BaseEntity{
    private String name;
}
