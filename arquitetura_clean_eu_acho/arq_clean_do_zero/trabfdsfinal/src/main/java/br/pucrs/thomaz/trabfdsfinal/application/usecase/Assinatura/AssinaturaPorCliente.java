package br.pucrs.thomaz.trabfdsfinal.application.usecase.Assinatura;

import br.pucrs.thomaz.trabfdsfinal.application.dto.AssinaturaDTO;
import br.pucrs.thomaz.trabfdsfinal.application.mapper.AssinaturaMapper;
import br.pucrs.thomaz.trabfdsfinal.domain.entities.Cliente;
import br.pucrs.thomaz.trabfdsfinal.domain.repository.AssinaturaRepository;
import br.pucrs.thomaz.trabfdsfinal.domain.repository.ClienteRepository;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssinaturaPorCliente {

    private final ClienteRepository clienteRepository;
    private final AssinaturaRepository assinaturaRepository;

    public AssinaturaPorCliente(ClienteRepository clienteRepository, AssinaturaRepository assinaturaRepository) {
        this.clienteRepository = clienteRepository;
        this.assinaturaRepository = assinaturaRepository;
    }

    public List<AssinaturaDTO> execute(Long clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId)
            .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));

        
        List<AssinaturaDTO> assinaturas = assinaturaRepository.findByCliente(cliente)
            .stream()
            .map(AssinaturaMapper::toDTO)
            .collect(Collectors.toList());

        return assinaturas;
    }
}
