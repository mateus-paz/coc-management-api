package com.mateuspaz.cocmanagementapi.core.facade.dto;

import lombok.Data;

@Data
public abstract class AbstractDTO {

    private Long id;

    private boolean excluido = false;

}
