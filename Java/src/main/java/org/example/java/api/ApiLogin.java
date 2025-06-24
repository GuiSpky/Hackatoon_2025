package org.example.java.api;

import lombok.AllArgsConstructor;
import org.example.java.dto.LoginAutenticado;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

@RestController
@RequestMapping("/api/login")
@AllArgsConstructor
public class ApiLogin {

    private final AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity<String> login(@RequestBody LoginAutenticado loginAutenticado) {
        try {
            UsernamePasswordAuthenticationToken authToken =
                    new UsernamePasswordAuthenticationToken(
                            loginAutenticado.login(), loginAutenticado.password());

            Authentication authentication = authenticationManager.authenticate(authToken);

            return ResponseEntity.ok("Usuário autenticado com sucesso!");

        } catch (BadCredentialsException e) {
            return ResponseEntity.status(401).body("Usuário ou senha inválidos");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro interno: " + e.getMessage());
        }
    }
}

