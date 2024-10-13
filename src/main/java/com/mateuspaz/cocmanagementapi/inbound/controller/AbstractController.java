package com.mateuspaz.cocmanagementapi.inbound.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mateuspaz.cocmanagementapi.core.domain.entity.AbstractEntity;
import com.mateuspaz.cocmanagementapi.core.facade.AbstractFacade;
import com.mateuspaz.cocmanagementapi.core.facade.dto.AbstractDTO;

public abstract class AbstractController<ENTITY extends AbstractEntity, DTO extends AbstractDTO> {

    protected final AbstractFacade<ENTITY, DTO> facade;

    protected AbstractController(AbstractFacade<ENTITY, DTO> facade) {
        this.facade = facade;
    }

    @PostMapping
    public ResponseEntity<DTO> salvar(@RequestBody DTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(facade.salvar(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(facade.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DTO> atualizar(@PathVariable Long id, @RequestBody DTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(facade.salvar(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        facade.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
