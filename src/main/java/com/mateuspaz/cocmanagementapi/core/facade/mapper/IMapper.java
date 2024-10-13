package com.mateuspaz.cocmanagementapi.core.facade.mapper;

import com.mateuspaz.cocmanagementapi.core.domain.entity.AbstractEntity;
import com.mateuspaz.cocmanagementapi.core.facade.dto.AbstractDTO;

public interface IMapper<ENTITY extends AbstractEntity, DTO extends AbstractDTO> {

    DTO toDTO(ENTITY entity);

    ENTITY toEntity(DTO dto);

}
