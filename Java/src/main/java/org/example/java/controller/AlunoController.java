package org.example.java.controller;

import org.example.java.model.Aluno;
import org.example.java.repository.TurmaRepository;
import org.example.java.service.AlunoService;
import org.example.java.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@RequestMapping("aluno")
public class AlunoController {

    @Autowired
    private AlunoService service;
    @Autowired
    private TurmaService turmaService;

    @GetMapping("/cadastro")
    public String iniciar(Aluno aluno, Model model) {
        model.addAttribute("aluno", new Aluno());
        model.addAttribute("turmas", turmaService.listarTodos());

        return "aluno/formulario";
    }

    @GetMapping()
    public String listar(Model model) {
        model.addAttribute("alunos", service.listarTodos());
        return "aluno/lista";
    }

    @PostMapping("salvar")
    public String salvar(Aluno aluno, Model model) {
        service.salvar(aluno);
        return "redirect:/aluno";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("aluno", service.buscarPorId(id));
        model.addAttribute("turmas", turmaService.listarTodos());
        return "aluno/formulario";
    }


    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id, Model model) {
        service.deletarPorId(id);
        return "redirect:/alunos";
    }

}
