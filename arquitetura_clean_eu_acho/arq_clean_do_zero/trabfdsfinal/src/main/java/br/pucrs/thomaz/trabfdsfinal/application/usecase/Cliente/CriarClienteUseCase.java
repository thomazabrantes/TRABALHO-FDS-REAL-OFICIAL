package br.pucrs.thomaz.trabfdsfinal.application.usecase.Cliente;

import br.pucrs.thomaz.trabfdsfinal.application.dto.ClienteDTO;
import br.pucrs.thomaz.trabfdsfinal.domain.entities.Cliente;
import br.pucrs.thomaz.trabfdsfinal.domain.repository.ClienteRepository;

import org.springframework.stereotype.Service;

@Service
public class CriarClienteUseCase {

    private final ClienteRepository clienteRepository;

    public CriarClienteUseCase(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteDTO execute(String nome, String email) {
    Cliente cliente = Cliente.criar(nome, email);
    cliente = clienteRepository.save(cliente);
    return new ClienteDTO(cliente.getCodigo(), cliente.getNome(), cliente.getEmail());
}

}