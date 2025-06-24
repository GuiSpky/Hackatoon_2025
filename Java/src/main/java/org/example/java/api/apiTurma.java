package org.example.java.api;

import lombok.AllArgsConstructor;
import org.example.java.model.Turma;
import org.example.java.service.TurmaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Turma")
@AllArgsConstructor
public class apiTurma {


    private final TurmaService service;

    @GetMapping()
    public ResponseEntity<List<Turma>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @PostMapping()
    public ResponseEntity salvar(@RequestBody Turma turma) {
        service.salvar(turma);
        return ResponseEntity.ok().build();
    }

    @PutMapping()
    public ResponseEntity alterar(@RequestBody Turma turma) {
        service.salvar(turma);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletar(@PathVariable(name = "id") Long id) {
        service.deletarPorId(id);
        return ResponseEntity.ok().build();
    }
}
