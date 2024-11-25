package br.pucrs.thomaz.trabfdsfinal.application.usecase.Assinatura;

import java.util.List;

import org.springframework.stereotype.Service;

import br.pucrs.thomaz.trabfdsfinal.domain.entities.Pagamento;
import br.pucrs.thomaz.trabfdsfinal.domain.repository.PagamentoRepository;

@Service
public class ListarPagamentosUseCase {

    private final PagamentoRepository pagamentoRepository;

    public ListarPagamentosUseCase(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    public List<Pagamento> listarPagamentos() {
        return pagamentoRepository.findAll(); // Retorna todos os pagamentos do banco
    }
}

