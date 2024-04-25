package br.com.eletra.offenders.mappers;

import br.com.eletra.offenders.dtos.common.IdAndNameDto;
import br.com.eletra.offenders.dtos.line.LineDto;
import br.com.eletra.offenders.entities.LineEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper (componentModel = "spring")
public abstract class LineMapper {

    public abstract LineDto toLineDto(LineEntity lineEntity);

    public abstract List<LineDto> toLineDto(List<LineEntity> lineEntityList);

    public abstract IdAndNameDto toIdAndNameDto(LineEntity lineEntity);

}
