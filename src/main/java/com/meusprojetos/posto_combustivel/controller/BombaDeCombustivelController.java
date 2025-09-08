package com.meusprojetos.posto_combustivel.controller;

import com.meusprojetos.posto_combustivel.dto.BombaDeCombustivelRequestDTO;
import com.meusprojetos.posto_combustivel.dto.BombaDeCombustivelResponseDTO;
import com.meusprojetos.posto_combustivel.service.BombaDeCombustivelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/bombas-combustivel")
public class BombaDeCombustivelController {

    private final BombaDeCombustivelService bombaDeCombustivelService;

    @PostMapping
    public ResponseEntity<BombaDeCombustivelResponseDTO> create(@RequestBody BombaDeCombustivelRequestDTO dto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(bombaDeCombustivelService.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BombaDeCombustivelResponseDTO> getById(@PathVariable Long id) {

        return ResponseEntity.ok().body(bombaDeCombustivelService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<BombaDeCombustivelResponseDTO>> getAll() {

        return ResponseEntity.ok().body(bombaDeCombustivelService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<BombaDeCombustivelResponseDTO> updateById(
            @PathVariable Long id,
            @RequestBody BombaDeCombustivelRequestDTO dto) {

        return ResponseEntity.ok().body(bombaDeCombustivelService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {

        bombaDeCombustivelService.detele(id);
        return ResponseEntity.noContent().build();
    }
}
