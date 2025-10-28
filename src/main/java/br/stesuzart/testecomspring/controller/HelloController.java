package br.stesuzart.testecomspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @GetMapping("/api/public")
    public String publicEndpoint() {
        return "Público: sem autenticação";
    }


    @GetMapping("/api/user")
    public String userEndpoint() {
        return "Área USER: olá, usuário!";
    }


    @GetMapping("/api/admin")
    public String adminEndpoint() {
        return "Área ADMIN: olá, admin!";
    }
}