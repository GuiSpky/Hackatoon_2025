package org.example.java.api;

import lombok.AllArgsConstructor;
import org.example.java.model.Aluno;
import org.example.java.model.Turma;
import org.example.java.service.AlunoService;
import org.example.java.service.TurmaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Aluno")
@AllArgsConstructor
public class apiAluno {

    private final AlunoService service;

    @GetMapping()
    public ResponseEntity<List<Aluno>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/turma/{turmaId}")
    public ResponseEntity<List<Aluno>> listarPorTurma(@PathVariable(name = "turmaId") Long turmaId) {
        List<Aluno> alunos = service.listarAlunosPorTurmaId(turmaId);
        if (alunos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(alunos);
    }
    @PostMapping()
    public ResponseEntity salvar(@RequestBody Aluno aluno) {
        service.salvar(aluno);
        return ResponseEntity.ok().build();
    }

    @PutMapping()
    public ResponseEntity alterar(@RequestBody Aluno aluno) {
        service.salvar(aluno);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletar(@PathVariable(name = "id") Long id) {
        service.deletarPorId(id);
        return ResponseEntity.ok().build();
    }
}
