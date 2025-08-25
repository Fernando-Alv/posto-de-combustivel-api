package com.meusprojetos.posto_combustivel.controller;

import com.meusprojetos.posto_combustivel.dto.TipoDeCombustivelDTO;
import com.meusprojetos.posto_combustivel.service.TipoDeCombustivelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tipos-combustivel")
public class TipoDeCombustivelController {

    private final TipoDeCombustivelService tipoDeCombustivelService;

    @PostMapping
    public ResponseEntity<TipoDeCombustivelDTO> create(@RequestBody TipoDeCombustivelDTO dto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(tipoDeCombustivelService.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoDeCombustivelDTO> getById(@PathVariable Long id) {

        return ResponseEntity.ok().body(tipoDeCombustivelService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<TipoDeCombustivelDTO>> getAll() {

        return ResponseEntity.ok().body(tipoDeCombustivelService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoDeCombustivelDTO> updateById(@PathVariable Long id, @RequestBody TipoDeCombustivelDTO dto) {

        return ResponseEntity.ok().body(tipoDeCombustivelService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {

        tipoDeCombustivelService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
