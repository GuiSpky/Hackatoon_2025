package org.example.java;

import org.example.java.model.Usuario;
import org.example.java.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class JavaApplication {

    public static void main(String[] args) {SpringApplication.run(JavaApplication.class, args);}
    @Bean
    public CommandLineRunner initDataBase(UsuarioRepository usuarioRepository) {
        return args -> {

            usuarioRepository.save(new Usuario(null, "admin@gmail.com", new BCryptPasswordEncoder().encode("123456"), "Admin", "ADMIN"));
            usuarioRepository.save(new Usuario(null, "professor@gmail.com", new BCryptPasswordEncoder().encode("123456"), "Professor", "PROFESSOR"));
            usuarioRepository.save(new Usuario(null, "aluno@gmail.com", new BCryptPasswordEncoder().encode("123456"), "Aluno", "ALUNO"));
//            usuarioRepository.save(new Usuario(null, "professor@gmail.com", new BCryptPasswordEncoder().encode("123456"), "Professor", "PROFESSOR"));
        };
    }
}
