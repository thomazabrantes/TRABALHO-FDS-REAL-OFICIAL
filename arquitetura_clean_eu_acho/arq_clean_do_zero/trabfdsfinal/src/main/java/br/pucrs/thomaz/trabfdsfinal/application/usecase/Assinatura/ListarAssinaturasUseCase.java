package br.pucrs.thomaz.trabfdsfinal.application.usecase.Assinatura;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.pucrs.thomaz.trabfdsfinal.application.dto.AssinaturaDTO;
import br.pucrs.thomaz.trabfdsfinal.application.mapper.AssinaturaMapper;
import br.pucrs.thomaz.trabfdsfinal.domain.repository.AssinaturaRepository;

@Service
public class ListarAssinaturasUseCase {
    private final AssinaturaRepository assinaturaRepository;

    public ListarAssinaturasUseCase(AssinaturaRepository assinaturaRepository) {
        this.assinaturaRepository = assinaturaRepository;
    }

    public List<AssinaturaDTO> execute() {
        return assinaturaRepository.findAll().stream()
                .map(AssinaturaMapper::toDTO) // Mapeia cada aplicativo para DTO
                .collect(Collectors.toList());
    }
}
