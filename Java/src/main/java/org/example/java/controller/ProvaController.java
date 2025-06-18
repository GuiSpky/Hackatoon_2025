package org.example.java.controller;

import org.example.java.model.Prova;
import org.example.java.model.ItemPergunta;
import org.example.java.service.ProvaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@RequestMapping("prova")
public class ProvaController {

    @Autowired
    private ProvaService service;

    @GetMapping()
    public String iniciar(Prova prova, Model model) {
        return "prova/formulario";
    }

    @PostMapping()
    public String inserir(Prova prova, ItemPergunta itemPergunta, Model model) {
        itemPergunta.setId(null);

        if (prova.getItens() == null) prova.setItens(Arrays.asList(itemPergunta));
        else prova.getItens().add(itemPergunta);

        return iniciar(prova, model);
    }

    @PostMapping("{index}")
    public String removerItem(@PathVariable int index, Prova prova, Model model) {
        prova.getItens().remove(index);
        return iniciar(prova, model);
    }

    @PostMapping("salvar")
    public String salvar(Prova prova, Model model) {
        try {
            service.salvar(prova);
            return "redirect:/prova/listar";
        } catch (Exception e) {
            model.addAttribute("errotitulo", "Algo de errado não deu certo: ");
            model.addAttribute("erro", "Entre em contato!");
            return iniciar(prova,model);
        }
    }

    @GetMapping("listar")
    public String listar(Model model) {
        model.addAttribute("provas", service.listarTodos());
        return "prova/lista";
    }

    @GetMapping("editar/{id}")
    public String alterar(@PathVariable Long id, Model model) {
        model.addAttribute("prova", service.buscarPorId(id));
        return "prova/formulario";
    }

    @GetMapping("remover/{id}")
    public String remover(@PathVariable Long id, Model model) {
        service.deletarPorId(id);
        return "redirect:/prova/listar";
    }

}
