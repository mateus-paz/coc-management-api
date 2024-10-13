package com.mateuspaz.cocmanagementapi.core.facade.dto;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public abstract class AbstractAuditDTO extends AbstractDTO {

    private String usuarioInsercao;

    private LocalDateTime dataInsercao;

    private String usuarioAtualizacao;

    private LocalDateTime dataAtualizacao;

}
