package br.pucrs.thomaz.trabfdsfinal.application.usecase.Assinatura;

import org.springframework.stereotype.Service;

import br.pucrs.thomaz.trabfdsfinal.application.dto.AssinaturaDTO;
import br.pucrs.thomaz.trabfdsfinal.domain.entities.Aplicativo;
import br.pucrs.thomaz.trabfdsfinal.domain.entities.Assinatura;
import br.pucrs.thomaz.trabfdsfinal.domain.entities.Cliente;
import br.pucrs.thomaz.trabfdsfinal.domain.repository.AssinaturaRepository;

@Service
public class CriarAssinaturaUseCase {
    private final AssinaturaRepository assinaturaRepository;

    public CriarAssinaturaUseCase(AssinaturaRepository assinaturaRepository) {
        this.assinaturaRepository = assinaturaRepository;
    }

    public AssinaturaDTO execute(Aplicativo app, Cliente cliente) {
        Assinatura assinatura = Assinatura.criar(app, cliente);
        assinatura = assinaturaRepository.save(assinatura);
        return new AssinaturaDTO(assinatura.getCodigo(), assinatura.getAplicativo(), assinatura.getCliente());
    }
}
