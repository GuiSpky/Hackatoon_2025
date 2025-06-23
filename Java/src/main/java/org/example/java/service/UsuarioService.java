package org.example.java.service;

import lombok.AllArgsConstructor;
import org.example.java.model.Usuario;
import org.example.java.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public void salvar(Usuario usuario) {
        // Verifica se é novo ou edição
        if (usuario.getId() == null) {
            // Novo usuário → criptografa a senha
            usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        } else {
            // Usuário existente → mantém a senha antiga, a menos que tenha sido alterada
            Usuario existente = repository.findById(usuario.getId()).orElseThrow();

            if (!usuario.getPassword().equals(existente.getPassword())) {
                usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
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
