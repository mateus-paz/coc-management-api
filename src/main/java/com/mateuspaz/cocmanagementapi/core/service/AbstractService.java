package com.mateuspaz.cocmanagementapi.core.service;

import com.mateuspaz.cocmanagementapi.core.domain.entity.AbstractEntity;
import com.mateuspaz.cocmanagementapi.core.domain.repository.IRepository;
import com.mateuspaz.cocmanagementapi.core.exception.CocManagementException;

public abstract class AbstractService<ENTITY extends AbstractEntity> {

    protected final IRepository<ENTITY> repository;

    protected AbstractService(IRepository<ENTITY> repository) {
        this.repository = repository;
    }

    public ENTITY salvar(ENTITY entity) {
        return repository.save(entity);
    }

    public ENTITY buscarPorId(Long id) {
        return repository.findByIdAndExcluido(id, Boolean.FALSE).orElse(null);
    }

    public ENTITY atualizar(Long id, ENTITY entity) {
        if (!repository.existsByIdAndExcluido(id, Boolean.FALSE))
            throw new CocManagementException("Não foi encontrado registro ativo pra o id informado");
        entity.setId(id);
        return repository.save(entity);
    }

    public void excluir(Long id) {
        repository.findByIdAndExcluido(id, Boolean.FALSE).ifPresent((entidade) -> entidade.setExcluido(true));
    }

}
