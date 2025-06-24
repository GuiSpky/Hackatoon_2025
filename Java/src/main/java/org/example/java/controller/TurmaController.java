package org.example.java.controller;

import org.example.java.model.Aluno;
import org.example.java.model.Turma;
import org.example.java.service.AlunoService;
import org.example.java.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("turma")
public class TurmaController {

    @Autowired
    private TurmaService service;

    @GetMapping("/cadastro")
    public String iniciar(Aluno aluno, Model model) {
        model.addAttribute("turma", new Aluno());
        return "turma/formulario";
    }

    @GetMapping()
    public String listar(Model model) {
        model.addAttribute("turma", service.listarTodos());
        return "turma/lista";
    }

    @PostMapping("salvar")
    public String salvar(Turma turma, Model model) {
        try {
            service.salvar(turma);
            return "redirect:/turma";
        } catch (Exception e) {
            model.addAttribute("erro", "Ocorreu um erro ao salvar o cadastro: " + e.getMessage());
            return "turma/cadastro";
        }
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("turma", service.buscarPorId(id));
        return "turma/formulario";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id, Model model) {
        service.deletarPorId(id);
        return "redirect:/turma";
    }

}
