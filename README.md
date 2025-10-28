# testes-automatizados-exemplo

# Teste rápido via curl
### endpoint público
curl http://localhost:8080/api/public

### usuário comum
curl -u user:123 http://localhost:8080/api/user

### administrador
curl -u admin:123 http://localhost:8080/api/admin

# Dicas

- As senhas estão criptografadas com BCrypt (PasswordEncoder).
- O csrf está desabilitado apenas para simplificar os testes; reabilite em produção.
- As roles seguem o padrão ROLE_... exigido pelo Spring Security.
- O console H2 precisa de frameOptions(sameOrigin) para funcionar no navegador.
