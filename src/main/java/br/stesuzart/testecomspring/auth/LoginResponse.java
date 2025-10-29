package br.stesuzart.testecomspring.auth;

public record LoginResponse(String token, String tokenType) {
    public LoginResponse(String t) {
        this(t, "Bearer");
    }
}