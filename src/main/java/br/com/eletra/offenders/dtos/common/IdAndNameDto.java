package br.com.eletra.offenders.dtos.common;

import lombok.Data;

import java.util.UUID;

@Data
public class IdAndNameDto {
    private UUID id;
    private String name;
}
