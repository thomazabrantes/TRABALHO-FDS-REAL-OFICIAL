package br.pucrs.thomaz.trabfdsfinal.application.usecase.Aplicativo;

import br.pucrs.thomaz.trabfdsfinal.application.dto.AplicativoDTO;
import br.pucrs.thomaz.trabfdsfinal.domain.entities.Aplicativo;
import br.pucrs.thomaz.trabfdsfinal.domain.repository.AplicativoRepository;
import org.springframework.stereotype.Service;

@Service
public class CriarAplicativoUseCase {

    private final AplicativoRepository aplicativoRepository;

    public CriarAplicativoUseCase(AplicativoRepository aplicativoRepository) {
        this.aplicativoRepository = aplicativoRepository;
    }

    public AplicativoDTO execute(String nome, double custoMensal) {
    Aplicativo aplicativo = Aplicativo.criar(nome, custoMensal);
    aplicativo = aplicativoRepository.save(aplicativo);
    return new AplicativoDTO(aplicativo.getCodigo(), aplicativo.getNome(), aplicativo.getCustoMensal());
}

}

