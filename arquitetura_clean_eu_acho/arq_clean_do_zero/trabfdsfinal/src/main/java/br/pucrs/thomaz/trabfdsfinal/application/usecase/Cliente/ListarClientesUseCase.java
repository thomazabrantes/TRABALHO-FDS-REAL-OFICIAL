package br.pucrs.thomaz.trabfdsfinal.application.usecase.Cliente;

import br.pucrs.thomaz.trabfdsfinal.application.dto.ClienteDTO;
import br.pucrs.thomaz.trabfdsfinal.application.mapper.ClienteMapper;
import br.pucrs.thomaz.trabfdsfinal.domain.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarClientesUseCase {

    private final ClienteRepository clienteRepository;

    public ListarClientesUseCase(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<ClienteDTO> execute() {
        // Busca todos os clientes no repositório e converte para DTO
        return clienteRepository.findAll().stream()
                .map(ClienteMapper::toDTO) // Mapeia cada cliente para DTO
                .collect(Collectors.toList());
    }
}
