package br.com.eletra.offenders.mappers;

import br.com.eletra.offenders.dtos.common.IdAndNameDto;
import br.com.eletra.offenders.dtos.line.LineDto;
import br.com.eletra.offenders.entities.LineEntity;
import org.springframework.stereotype.Component;

@Component
public class LineMapper {

    public LineDto toLineDto(LineEntity lineEntity) {
        LineDto lineDto = new LineDto();
        IdAndNameDto idAndNameDto = new IdAndNameDto();
        idAndNameDto.setId(lineEntity.getId());
        lineDto.setName(lineEntity.getName());
        return lineDto;
    }

    public IdAndNameDto toIdAndNameDto(LineEntity lineEntity) {
        IdAndNameDto idAndNameDto = new IdAndNameDto();
        idAndNameDto.setId(lineEntity.getId());
        idAndNameDto.setName(lineEntity.getName());
        return idAndNameDto;
    }
}
