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

            usuarioRepository.save(new Usuario(null, "admin", new BCryptPasswordEncoder().encode("admin"), "Admin", "ADMIN"));
        };
    }
}
