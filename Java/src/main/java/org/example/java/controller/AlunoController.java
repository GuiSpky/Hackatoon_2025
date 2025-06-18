package org.example.java.controller;

import org.example.java.model.Aluno;
import org.example.java.service.AlunoService;
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

    @GetMapping()
    public String listar(Model model) {
        model.addAttribute("aluno", service.listarTodos());
        return "aluno/lista";
    }

    @GetMapping("/novo")
    public String iniciar(Aluno medico, Model model) {
        model.addAttribute("aluno", new Aluno());
        return "aluno/cadastro";
    }

    @PostMapping()
    public String salvar(Aluno aluno, Model model) {
        try {
            service.salvar(aluno);
            return "redirect:/alunos";
        } catch (Exception e) {
            model.addAttribute(
                    "erro",
                    "Ocorreu um erro ao salvar o cadastro: " + e.getMessage());
            return "aluno/cadastro";
        }
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("aluno", service.buscarPorId(id));
        return "aluno/cadastro";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id, Model model) {
        service.deletarPorId(id);
        return "redirect:/alunos";
    }

}
