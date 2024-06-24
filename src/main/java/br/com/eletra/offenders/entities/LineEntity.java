package br.com.eletra.offenders.entities;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Entity(name = "lines")
@Getter
@Setter
public class LineEntity extends BaseEntity {
    private String name;
}
