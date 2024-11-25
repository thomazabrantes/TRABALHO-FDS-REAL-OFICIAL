package br.pucrs.thomaz.trabfdsfinal.application.usecase.Assinatura;

import org.springframework.stereotype.Service;

import br.pucrs.thomaz.trabfdsfinal.domain.entities.Assinatura;
import br.pucrs.thomaz.trabfdsfinal.domain.repository.AssinaturaRepository;

@Service
public class VerificarValidade{
    private final AssinaturaRepository assinaturaRepository;

    public VerificarValidade (AssinaturaRepository assinaturaRepository) {
        this.assinaturaRepository = assinaturaRepository;
    }

    public boolean execute(Long clienteId, Long assinaturaId) {
        Assinatura assinatura = assinaturaRepository.findByClienteCodigoAndCodigo(clienteId, assinaturaId)
            .orElseThrow(() -> new IllegalArgumentException("Assinatura ou Cliente não encontrado"));

        return assinatura.isValida();
    }
}