package br.stesuzart.testecomspring.controller;

import br.stesuzart.testecomspring.auth.LoginRequest;
import br.stesuzart.testecomspring.auth.LoginResponse;
import br.stesuzart.testecomspring.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthenticationManager am;
    private final JwtUtil jwt;

    public AuthController(AuthenticationManager am, JwtUtil jwt) { this.am = am; this.jwt = jwt; }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest req) {
        Authentication auth = am.authenticate(new UsernamePasswordAuthenticationToken(req.username(), req.password()));
        String username = ((UserDetails) auth.getPrincipal()).getUsername();
        return ResponseEntity.ok(new LoginResponse(jwt.generate(username)));
    }
}
