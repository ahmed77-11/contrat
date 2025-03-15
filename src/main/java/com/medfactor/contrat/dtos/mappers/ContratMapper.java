package com.medfactor.contrat.dtos.mappers;

import com.medfactor.contrat.dtos.ContratDTO;
import com.medfactor.contrat.entities.Contrat;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ContratMapper {

    ContratMapper INSTANCE = Mappers.getMapper(ContratMapper.class);

    Contrat toEntity(ContratDTO dto);
    ContratDTO toDTO(Contrat entity);
}
