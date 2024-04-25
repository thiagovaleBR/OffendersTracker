package br.com.eletra.offenders.mappers;

import br.com.eletra.offenders.dtos.area.AreaDto;
import br.com.eletra.offenders.dtos.common.IdAndNameDto;
import br.com.eletra.offenders.entities.AreaEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class AreaMapper {

    public abstract AreaDto toAreaDto(AreaEntity areaEntity);

    public abstract List<AreaDto> toAreaDto(List<AreaEntity> areaEntityList);

    public abstract IdAndNameDto toIdAndNameDto (AreaEntity areaEntity);

}
