package org.example.java.service;

import lombok.RequiredArgsConstructor;
import org.example.java.model.Gabarito;
import org.example.java.repository.GabaritoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GabaritoService {

    private final GabaritoRepository gabaritoRepository;

    public List<Gabarito> listarTodos() {
        return gabaritoRepository.findAll();
    }

    public Optional<Gabarito> buscarPorId(Long id) {
        return gabaritoRepository.findById(id);
    }

    public Gabarito salvar(Gabarito gabarito) {
        return gabaritoRepository.save(gabarito);
    }

    public Gabarito atualizar(Long id, Gabarito novoGabarito) {
        return gabaritoRepository.findById(id)
                .map(gabaritoExistente -> {
//                    gabaritoExistente.setAluno(novoGabarito.getAluno());
//                    gabaritoExistente.setProva(novoGabarito.getProva());
//                    gabaritoExistente.setCorrecaoProva(novoGabarito.getCorrecaoProva());
                    gabaritoExistente.setRespostas(novoGabarito.getRespostas());
                    return gabaritoRepository.save(gabaritoExistente);
                })
                .orElseThrow(() -> new RuntimeException("Gabarito não encontrado com ID: " + id));
    }

    public void deletar(Long id) {
        gabaritoRepository.deleteById(id);
    }
}