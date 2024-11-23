package br.pucrs.thomaz.trabfdsfinal.application.usecase.Cliente;

import br.pucrs.thomaz.trabfdsfinal.application.dto.ClienteDTO;
import br.pucrs.thomaz.trabfdsfinal.domain.entities.Cliente;
import br.pucrs.thomaz.trabfdsfinal.domain.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EditarClienteUseCase {

    private final ClienteRepository clienteRepository;

    public EditarClienteUseCase(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public ClienteDTO execute(Long codigo, String novoNome, String novoEmail) {
        // Busca o cliente pelo ID
        Cliente cliente = clienteRepository.findById(codigo)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado com o código: " + codigo));

        // Atualiza os valores se forem válidos
        if (novoNome != null && !novoNome.trim().isEmpty()) {
            cliente.setNome(novoNome);
        }

        if (novoEmail != null && !novoEmail.trim().isEmpty()) {
            if (!novoEmail.contains("@")) {
                throw new IllegalArgumentException("Email inválido.");
            }
            cliente.setEmail(novoEmail);
        }

        // Salva o cliente atualizado no repositório
        cliente = clienteRepository.save(cliente);

        // Retorna o DTO atualizado
        return new ClienteDTO(cliente.getCodigo(), cliente.getNome(), cliente.getEmail());
    }
}
