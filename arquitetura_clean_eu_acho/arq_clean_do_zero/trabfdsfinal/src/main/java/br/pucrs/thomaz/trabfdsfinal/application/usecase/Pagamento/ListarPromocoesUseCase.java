package br.pucrs.thomaz.trabfdsfinal.application.usecase.Pagamento;

import java.util.List;

import org.springframework.stereotype.Service;

import br.pucrs.thomaz.trabfdsfinal.domain.entities.Promocao;
import br.pucrs.thomaz.trabfdsfinal.domain.repository.PromocaoRepository;

@Service
public class ListarPromocoesUseCase {
    private final PromocaoRepository promocaoRepository;

    public ListarPromocoesUseCase(PromocaoRepository promocaoRepository) {
        this.promocaoRepository = promocaoRepository;
    }

    public List<Promocao> listarPromocoes() {
        return promocaoRepository.findAll();
    }

    
}
