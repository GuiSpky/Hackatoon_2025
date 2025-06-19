package org.example.java.controller;

import org.example.java.model.Aluno;
import org.example.java.model.Materia;
import org.example.java.service.AlunoService;
import org.example.java.service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("aluno")
public class MateriaController {


    @Autowired
    private MateriaService service;

    @GetMapping()
    public String listar(Model model) {
        model.addAttribute("materia", service.listarTodos());
        return "materia/lista";
    }

    @GetMapping("/novo")
    public String iniciar(Materia materia, Model model) {
        model.addAttribute("aluno", new Aluno());
        return "aluno/cadastro";
    }

    @PostMapping()
    public String salvar(Materia materia, Model model) {
        try {
            service.salvar(materia);
            return "redirect:/materias";
        } catch (Exception e) {
            model.addAttribute(
                    "erro",
                    "Ocorreu um erro ao salvar o cadastro: " + e.getMessage());
            return "materia/cadastro";
        }
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("materia", service.buscarPorId(id));
        return "materia/cadastro";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id, Model model) {
        service.deletarPorId(id);
        return "redirect:/alunos";
    }
}
