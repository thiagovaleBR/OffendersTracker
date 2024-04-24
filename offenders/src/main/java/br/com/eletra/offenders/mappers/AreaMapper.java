package br.com.eletra.offenders.mappers;

import br.com.eletra.offenders.dtos.area.AreaDto;
import br.com.eletra.offenders.dtos.common.IdAndNameDto;
import br.com.eletra.offenders.entities.AreaEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AreaMapper {

    public AreaDto toAreaDto(AreaEntity areaEntity) {
        AreaDto areaDto = new AreaDto();
        IdAndNameDto idAndNameDto = new IdAndNameDto();
        idAndNameDto.setId(areaEntity.getId());
        areaDto.setName(areaEntity.getName());

        return areaDto;
    }

        public IdAndNameDto toIdAndNameDto(AreaEntity areaEntity) {
        IdAndNameDto idAndNameDto = new IdAndNameDto();
        idAndNameDto.setId(areaEntity.getId());
        idAndNameDto.setName(areaEntity.getName());
        return idAndNameDto;
    }
}
