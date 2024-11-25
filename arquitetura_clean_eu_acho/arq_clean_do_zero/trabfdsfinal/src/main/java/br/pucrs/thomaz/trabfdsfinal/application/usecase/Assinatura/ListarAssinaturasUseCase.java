package br.pucrs.thomaz.trabfdsfinal.application.usecase.Assinatura;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.pucrs.thomaz.trabfdsfinal.application.dto.AssinaturaDTO;
import br.pucrs.thomaz.trabfdsfinal.application.mapper.AssinaturaMapper;
import br.pucrs.thomaz.trabfdsfinal.domain.entities.Assinatura;  // Importando a classe Assinatura
import br.pucrs.thomaz.trabfdsfinal.domain.repository.AssinaturaRepository;

@Service
public class ListarAssinaturasUseCase {
    private final AssinaturaRepository assinaturaRepository;

    public ListarAssinaturasUseCase(AssinaturaRepository assinaturaRepository) {
        this.assinaturaRepository = assinaturaRepository;
    }

    public List<AssinaturaDTO> execute(String tipo) {
        List<Assinatura> assinaturas = assinaturaRepository.findAll();  // Agora 'Assinatura' é reconhecida

        switch (tipo.toUpperCase()) {
            case "ATIVAS":
                return assinaturas.stream()
                        .filter(assinatura -> assinatura.isValida()) // Considera assinaturas ativas
                        .map(AssinaturaMapper::toDTO)
                        .collect(Collectors.toList());
            case "CANCELADAS":
                return assinaturas.stream()
                        .filter(assinatura -> !assinatura.isValida()) // Considera assinaturas não ativas
                        .map(AssinaturaMapper::toDTO)
                        .collect(Collectors.toList());
            case "TODAS":
                return assinaturas.stream()
                        .map(AssinaturaMapper::toDTO)
                        .collect(Collectors.toList());
            default:
                throw new IllegalArgumentException("Tipo inválido. Use 'TODAS', 'ATIVAS' ou 'CANCELADAS'");
        }
    }
}
