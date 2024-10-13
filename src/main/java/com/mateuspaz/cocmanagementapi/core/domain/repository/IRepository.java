package com.mateuspaz.cocmanagementapi.core.domain.repository;

import java.util.Optional;

import com.mateuspaz.cocmanagementapi.core.domain.entity.AbstractEntity;

public interface IRepository<ENTITY extends AbstractEntity> {

    ENTITY save(ENTITY entity);

    Optional<ENTITY> findByIdAndExcluido(Long id, boolean excluido);

    boolean existsByIdAndExcluido(Long id, boolean excluido);

}
