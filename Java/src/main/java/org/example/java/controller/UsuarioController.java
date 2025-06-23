package org.example.java.controller;

import org.example.java.model.Aluno;
import org.example.java.model.Usuario;
import org.example.java.service.AlunoService;
import org.example.java.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping("/cadastro")
    public String iniciar(Usuario usuario, Model model) {
        return "usuario/formulario";
    }

    @GetMapping()
    public String listar(Model model) {
        model.addAttribute("usuario", service.listAll());
        return "usuario/lista";
    }

    @PostMapping("salvar")
    public String salvar(Usuario usuario, Model model) {
            service.salvar(usuario);
            return "redirect:/usuario";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("usuario", service.buscarPorId(id));
        return "usuario/formulario";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id, Model model) {
        service.deletarPorId(id);
        return "redirect:/usuario";
    }
}
