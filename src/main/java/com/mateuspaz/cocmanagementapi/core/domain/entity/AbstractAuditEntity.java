package com.mateuspaz.cocmanagementapi.core.domain.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import com.mateuspaz.cocmanagementapi.core.domain.entity.listener.AuditEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EntityListeners(AuditEntityListener.class)
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public abstract class AbstractAuditEntity extends AbstractEntity {

    @CreatedBy
    @Column(updatable = false)
    private String usuarioInsercao;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime dataInsercao;

    @LastModifiedBy
    private String usuarioAtualizacao;

    @LastModifiedDate
    private LocalDateTime dataAtualizacao;

}
