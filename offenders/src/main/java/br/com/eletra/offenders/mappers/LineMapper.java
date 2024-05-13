package br.com.eletra.offenders.mappers;

import br.com.eletra.offenders.dtos.common.IdAndNameDto;
import br.com.eletra.offenders.dtos.line.LineDto;
import br.com.eletra.offenders.entities.LineEntity;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper (componentModel = "spring")
public abstract class LineMapper {

    public abstract LineDto toLineDto(Optional<LineEntity> lineEntity);

    public abstract List<LineDto> toLineDtoList(List<LineEntity> lineEntityList);

    public abstract IdAndNameDto toIdAndNameDto(LineEntity lineEntity);

}
