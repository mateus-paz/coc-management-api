package com.mateuspaz.cocmanagementapi.core.facade;

import com.mateuspaz.cocmanagementapi.core.domain.entity.AbstractEntity;
import com.mateuspaz.cocmanagementapi.core.facade.dto.AbstractDTO;
import com.mateuspaz.cocmanagementapi.core.facade.mapper.IMapper;
import com.mateuspaz.cocmanagementapi.core.service.AbstractService;

public abstract class AbstractFacade<ENTITY extends AbstractEntity, DTO extends AbstractDTO> {
    
    protected final IMapper<ENTITY, DTO> mapper;

    protected final AbstractService<ENTITY> service;

    protected AbstractFacade(IMapper<ENTITY, DTO> mapper, AbstractService<ENTITY> service) {
        this.mapper = mapper;
        this.service = service;
    }

    public DTO salvar(DTO dto) {
        ENTITY entidade = service.salvar(mapper.toEntity(dto));
        return mapper.toDTO(entidade);
    }

    public DTO buscarPorId(Long id) {
        return mapper.toDTO(service.buscarPorId(id));
    }

    public DTO atualizar(Long id, DTO dto) {
        ENTITY entidade = service.atualizar(id, mapper.toEntity(dto));
        return mapper.toDTO(entidade);
    }

    public void excluir(Long id) {
        service.excluir(id);
    }

}
