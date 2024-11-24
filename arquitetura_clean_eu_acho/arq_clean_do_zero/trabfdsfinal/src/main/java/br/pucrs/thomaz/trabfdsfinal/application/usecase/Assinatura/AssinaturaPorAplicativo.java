package br.pucrs.thomaz.trabfdsfinal.application.usecase.Assinatura;

import br.pucrs.thomaz.trabfdsfinal.application.dto.AssinaturaDTO;
import br.pucrs.thomaz.trabfdsfinal.application.mapper.AssinaturaMapper;
import br.pucrs.thomaz.trabfdsfinal.domain.entities.Aplicativo;
import br.pucrs.thomaz.trabfdsfinal.domain.repository.AssinaturaRepository;
import br.pucrs.thomaz.trabfdsfinal.domain.repository.AplicativoRepository;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssinaturaPorAplicativo {

    private final AplicativoRepository aplicativoRepository;
    private final AssinaturaRepository assinaturaRepository;

    public AssinaturaPorAplicativo(AplicativoRepository aplicativoRepository, AssinaturaRepository assinaturaRepository) {
        this.aplicativoRepository = aplicativoRepository;
        this.assinaturaRepository = assinaturaRepository;
    }

    public List<AssinaturaDTO> execute(Long aplicativoId) {
        Aplicativo aplicativo = aplicativoRepository.findById(aplicativoId)
            .orElseThrow(() -> new IllegalArgumentException("Aplicativo não encontrado"));

        List<AssinaturaDTO> assinaturas = assinaturaRepository.findByAplicativo(aplicativo)
            .stream()
            .map(AssinaturaMapper::toDTO)
            .collect(Collectors.toList());

        return assinaturas;
    }
}
