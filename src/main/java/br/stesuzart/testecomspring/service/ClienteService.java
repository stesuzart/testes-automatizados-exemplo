package br.stesuzart.testecomspring.service;

import br.stesuzart.testecomspring.model.entity.Cliente;
import br.stesuzart.testecomspring.model.repository.ClienteRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }
}
