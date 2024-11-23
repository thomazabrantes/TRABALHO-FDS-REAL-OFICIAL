package br.pucrs.thomaz.trabfdsfinal.application.usecase.Aplicativo;

import br.pucrs.thomaz.trabfdsfinal.application.dto.AplicativoDTO;
import br.pucrs.thomaz.trabfdsfinal.application.mapper.AplicativoMapper;
import br.pucrs.thomaz.trabfdsfinal.domain.repository.AplicativoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarAplicativosUseCase {

    private final AplicativoRepository aplicativoRepository;

    public ListarAplicativosUseCase(AplicativoRepository aplicativoRepository) {
        this.aplicativoRepository = aplicativoRepository;
    }

    public List<AplicativoDTO> execute() {
        // Busca todos os aplicativos no repositório e converte para DTO
        return aplicativoRepository.findAll().stream()
                .map(AplicativoMapper::toDTO) // Mapeia cada aplicativo para DTO
                .collect(Collectors.toList());
    }
}
