package org.example.java.controller;

import org.example.java.model.Aluno;
import org.example.java.model.Prova;
import org.example.java.model.ItemPergunta;
import org.example.java.service.AlunoService;
import org.example.java.service.ItemPerguntaService;
import org.example.java.service.ProvaService;
import org.example.java.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
@RequestMapping("prova")
@SessionAttributes("prova")
public class ProvaController {

    @Autowired
    private ProvaService service;

    @ModelAttribute("prova")
    public Prova prova() {
        return new Prova();
    }

    @GetMapping("/cadastro")
    public String iniciar(Model model) {
        model.addAttribute("prova", new Prova());
        return "prova/formulario";
    }

    @PostMapping("/adicionar")
    public String adicionar(@ModelAttribute("prova") Prova prova, String enunciado, String resposta, Float valor, Model model) {
        ItemPergunta item = new ItemPergunta();
        item.setEnunciado(enunciado);
        item.setResposta(resposta);
        item.setValor(valor);
        prova.getItens().add(item);
        return "prova/formulario";
    }

    @PostMapping("/remover/{index}")
    public String remover(@ModelAttribute("prova") Prova prova, @PathVariable int index) {
        if (index >= 0 && index < prova.getItens().size()) {
            prova.getItens().remove(index);
        }
        return "prova/formulario";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute("prova") Prova prova, SessionStatus status) {
        for (ItemPergunta item : prova.getItens()) {
            item.setProva(prova); // associar corretamente
        }
        service.salvar(prova);
        status.setComplete(); // limpa a sessão
        return "redirect:/prova/lista";
    }

    @GetMapping("/lista") // ✅ ESSA É A PARTE FALTANTE
    public String listarProvas(Model model) {
        model.addAttribute("provas", service.listarTodos());
        return "prova/lista";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        service.deletarPorId(id);
        return "redirect:/prova/lista";
    }

    @GetMapping("editar/{id}")
    public String alterar(@PathVariable Long id, Model model) {
        model.addAttribute("prova", service.buscarPorId(id));
        return "prova/formulario";
    }
}

