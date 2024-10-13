package com.mateuspaz.cocmanagementapi.core.domain.entity.listener;

import java.time.LocalDateTime;

import com.mateuspaz.cocmanagementapi.core.domain.entity.AbstractAuditEntity;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class AuditEntityListener {

    @PrePersist
    public void prePersist(AbstractAuditEntity entity) {
        entity.setDataInsercao(LocalDateTime.now());
    }

    @PreUpdate
    public void preUpdate(AbstractAuditEntity entity) {
        entity.setDataAtualizacao(LocalDateTime.now());
    }

}
