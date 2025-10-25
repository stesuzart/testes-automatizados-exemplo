package br.stesuzart.testecomspring.controller;

import br.stesuzart.testecomspring.model.entity.Cliente;
import br.stesuzart.testecomspring.service.ClienteService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/clients")
public class ClienteController {
    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes(){
        return new ResponseEntity<>(clienteService.listarClientes(),HttpStatus.ACCEPTED);
    }
}