package br.com.eletra.offenders.mappers;

import br.com.eletra.offenders.dtos.common.IdAndNameDto;
import br.com.eletra.offenders.entities.AreaEntity;
import org.springframework.stereotype.Component;

@Component

public class AreaMapper {
    public IdAndNameDto toIdAndNameDto(AreaEntity areaEntity) {
        IdAndNameDto idAndNameDto = new IdAndNameDto();
        idAndNameDto.setId(areaEntity.getId());
        idAndNameDto.setName(areaEntity.getName());
        return idAndNameDto;
    }
}
