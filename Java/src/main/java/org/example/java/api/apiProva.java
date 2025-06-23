package org.example.java.api;

import lombok.AllArgsConstructor;
import org.example.java.model.Aluno;
import org.example.java.model.Prova;
import org.example.java.service.AlunoService;
import org.example.java.service.ProvaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Prova")
@AllArgsConstructor
public class apiProva {

    private final ProvaService service;

    @GetMapping()
    public ResponseEntity<List<Prova>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @PostMapping()
    public ResponseEntity salvar(@RequestBody Prova prova) {
        service.salvar(prova);
        return ResponseEntity.ok().build();
    }

    @PutMapping()
    public ResponseEntity alterar(@RequestBody Prova prova) {
        service.salvar(prova);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletar(@PathVariable(name = "id") Long id) {
        service.deletarPorId(id);
        return ResponseEntity.ok().build();
    }
}
