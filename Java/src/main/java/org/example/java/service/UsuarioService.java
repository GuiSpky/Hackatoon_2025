package org.example.java.service;

import lombok.AllArgsConstructor;
import org.example.java.model.Aluno;
import org.example.java.model.Usuario;
import org.example.java.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService implements UserDetailsService {

    @Autowired
    private final UsuarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByLogin(username);
    }

    public void salvar(Usuario usuario) {
        // Verifica se está criando novo usuário ou editando existente
        if (usuario.getPassword() != null && !usuario.getPassword().isBlank()) {
            usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        } else if (usuario.getId() != null) {
            // Mantém a senha antiga se o campo estiver vazio ao editar
            Usuario existente = repository.findById(usuario.getId()).orElse(null);
            if (existente != null) {
                usuario.setPassword(existente.getPassword());
            }
        }

        repository.save(usuario);
    }


    public List<Usuario> listAll() {
        return repository.findAll();
    }

    // Busca o cadastro do médico através do id
    public Usuario buscarPorId(Long id) {
        return repository.findById(id).get();
    }

    // Deletar o médico
    public void deletarPorId(Long id) {
        repository.deleteById(id);
    }
}
