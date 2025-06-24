package org.example.java.api;

import lombok.RequiredArgsConstructor;
import org.example.java.model.Gabarito;
import org.example.java.service.GabaritoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gabarito")
@RequiredArgsConstructor
public class ApiGabarito {

    private final GabaritoService gabaritoService;

    @GetMapping
    public ResponseEntity<List<Gabarito>> listarTodos() {
        return ResponseEntity.ok(gabaritoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gabarito> buscarPorId(@PathVariable Long id) {
        return gabaritoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Gabarito> salvar(@RequestBody Gabarito gabarito) {
        return ResponseEntity.ok(gabaritoService.salvar(gabarito));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Gabarito> atualizar(@PathVariable Long id, @RequestBody Gabarito gabarito) {
        try {
            return ResponseEntity.ok(gabaritoService.atualizar(id, gabarito));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        gabaritoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}