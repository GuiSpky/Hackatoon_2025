package org.example.java.api;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.java.model.Aluno;
import org.example.java.model.Gabarito;
import org.example.java.model.ItemPergunta;
import org.example.java.model.Prova;
import org.example.java.service.AlunoService;
import org.example.java.service.GabaritoService;
import org.example.java.service.ProvaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gabarito")
@RequiredArgsConstructor
public class ApiGabarito {

    private final GabaritoService gabaritoService;
    private final ProvaService provaService;
    private final AlunoService alunoService;

    @PostMapping("/corrigir/{provaId}/aluno/{alunoId}")
    public ResponseEntity<?> corrigirProva(
            @PathVariable Long provaId,
            @PathVariable Long alunoId,
            @RequestBody RespostasAlunoDTO respostasAluno) {

        Prova prova = provaService.buscarPorId(provaId);
        Aluno aluno = alunoService.buscarPorId(alunoId);

        if (prova == null || prova.getItens().isEmpty()) {
            return ResponseEntity.badRequest().body("Prova não encontrada ou sem perguntas.");
        }

        if (aluno == null) {
            return ResponseEntity.badRequest().body("Aluno não encontrado.");
        }

        List<String> respostas = respostasAluno.getRespostas();
        List<String> gabarito = prova.getItens()
                .stream()
                .map(ItemPergunta::getResposta)
                .toList();

        if (respostas.size() != gabarito.size()) {
            return ResponseEntity.badRequest().body("Número de respostas não corresponde ao número de perguntas.");
        }

        int acertos = 0;
        for (int i = 0; i < gabarito.size(); i++) {
            if (gabarito.get(i).equalsIgnoreCase(respostas.get(i))) {
                acertos++;
            }
        }

        // Salvar o Gabarito
        Gabarito novoGabarito = new Gabarito();
        novoGabarito.setAluno(aluno);
        novoGabarito.setProva(prova);
        novoGabarito.setValor(Float.valueOf(acertos));
        gabaritoService.salvar(novoGabarito);

        int total = gabarito.size();
        double percentual = ((double) acertos / total) * 100;

        return ResponseEntity.ok(new ResultadoDTO(acertos, total, percentual));
    }

    @Data
    static class RespostasAlunoDTO {
        private List<String> respostas;
    }

    @Data
    static class ResultadoDTO {
        private int acertos;
        private int total;
        private double percentual;

        public ResultadoDTO(int acertos, int total, double percentual) {
            this.acertos = acertos;
            this.total = total;
            this.percentual = percentual;
        }
    }
}
