package br.com.eletra.offenders.mappers;

import br.com.eletra.offenders.dtos.common.IdAndNameDto;
import br.com.eletra.offenders.entities.LineEntity;
import org.springframework.stereotype.Component;

@Component
public class LineMapper {

    public IdAndNameDto toIdAndNameDto(LineEntity lineEntity) {
        IdAndNameDto idAndNameDto = new IdAndNameDto();
        idAndNameDto.setId(lineEntity.getId());
        idAndNameDto.setName(lineEntity.getName());
        return idAndNameDto;
    }
}
