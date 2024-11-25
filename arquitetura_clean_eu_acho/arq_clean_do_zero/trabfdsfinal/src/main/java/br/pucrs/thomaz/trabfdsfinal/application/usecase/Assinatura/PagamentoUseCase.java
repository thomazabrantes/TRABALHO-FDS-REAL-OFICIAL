package br.pucrs.thomaz.trabfdsfinal.application.usecase.Assinatura;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import br.pucrs.thomaz.trabfdsfinal.domain.entities.Assinatura;
import br.pucrs.thomaz.trabfdsfinal.domain.entities.Pagamento;
import br.pucrs.thomaz.trabfdsfinal.domain.repository.AssinaturaRepository;
import br.pucrs.thomaz.trabfdsfinal.domain.repository.PagamentoRepository;

@Service
public class PagamentoUseCase {

    private final AssinaturaRepository assinaturaRepository;
    private final PagamentoRepository pagamentoRepository;

    public PagamentoUseCase(AssinaturaRepository assinaturaRepository, PagamentoRepository pagamentoRepository) {
        this.assinaturaRepository = assinaturaRepository;
        this.pagamentoRepository = pagamentoRepository;
    }

    public String processarPagamento(Long codigoAssinatura, double valorPago, String promocao) {
        Assinatura assinatura = assinaturaRepository.findById(codigoAssinatura)
                .orElseThrow(() -> new IllegalArgumentException("Assinatura não encontrada"));

        LocalDate dataPagamento = LocalDate.now();
        Pagamento pagamento = Pagamento.criar(assinatura, valorPago, dataPagamento, promocao);
        double valorEstornado = valorPago;

        // Valida o valor do pagamento
        double valorEsperado = assinatura.getAplicativo().getCustoMensal();

        if (valorPago == valorEsperado) {
            valorEstornado = 0;
            if (assinatura.getFimVigencia().isBefore(dataPagamento)) {
                // Reativação: 30 dias a partir da data atual
                assinatura.setFimVigencia(dataPagamento.plusDays(30));
            } else {
                // Extensão: 30 dias a partir da validade atual
                assinatura.setFimVigencia(assinatura.getFimVigencia().plusDays(30));
            }
            assinaturaRepository.save(assinatura);
            pagamentoRepository.save(pagamento);
            return "Pagamento processado com sucesso! Nova validade: " + assinatura.getFimVigencia();
        } else {
            return "Pagamento recusado. Valor esperado: " + valorEsperado + ", valor recebido: " + valorPago + "\nValor estornado: " + valorEstornado;
        }
    }
}
