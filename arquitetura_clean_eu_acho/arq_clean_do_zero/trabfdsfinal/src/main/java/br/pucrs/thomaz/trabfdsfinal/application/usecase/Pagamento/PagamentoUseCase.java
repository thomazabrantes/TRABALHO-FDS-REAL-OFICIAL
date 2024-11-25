package br.pucrs.thomaz.trabfdsfinal.application.usecase.Pagamento;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import br.pucrs.thomaz.trabfdsfinal.domain.entities.Assinatura;
import br.pucrs.thomaz.trabfdsfinal.domain.entities.Pagamento;
import br.pucrs.thomaz.trabfdsfinal.domain.entities.Promocao;
import br.pucrs.thomaz.trabfdsfinal.domain.repository.AssinaturaRepository;
import br.pucrs.thomaz.trabfdsfinal.domain.repository.PagamentoRepository;
import br.pucrs.thomaz.trabfdsfinal.domain.repository.PromocaoRepository;


@Service
public class PagamentoUseCase {

    private final AssinaturaRepository assinaturaRepository;
    private final PagamentoRepository pagamentoRepository;
    private final PromocaoRepository promocaoRepository;

    public PagamentoUseCase(AssinaturaRepository assinaturaRepository, PagamentoRepository pagamentoRepository, PromocaoRepository promocaoRepository) {
        this.assinaturaRepository = assinaturaRepository;
        this.pagamentoRepository = pagamentoRepository;
        this.promocaoRepository = promocaoRepository;
    }

    public String processarPagamento(Long codigoAssinatura, double valorPago, String promocao) {
        Assinatura assinatura = assinaturaRepository.findById(codigoAssinatura)
                .orElseThrow(() -> new IllegalArgumentException("Assinatura não encontrada"));

        LocalDate dataPagamento = LocalDate.now();
        double valorEstornado = valorPago;
        Pagamento pagamento = Pagamento.criar(assinatura, valorPago, dataPagamento, promocao);

        // Valida o valor do pagamento
        double valorEsperado = assinatura.getAplicativo().getCustoMensal();
        int diasExtras = 0;

        if (promocao != null && !promocao.isEmpty()) {
            Promocao promocaoObj = obterPromocao(promocao);
            if (promocaoObj == null) { //Se não encontrar a promoção no BD
                return "Promoção inexistente ou não aplicável. Valor estornado: " + valorEstornado;
            }

            // Aplica o desconto da promoção
            valorEsperado = valorEsperado - (valorEsperado * promocaoObj.getDesconto());
            diasExtras = promocaoObj.getDiasExtras();
        }

        if (valorPago == valorEsperado) {
            valorEstornado = 0;

            if (assinatura.getFimVigencia().isBefore(dataPagamento)) {
                // Reativação: 30 dias + dias extras a partir da data atual
                assinatura.setFimVigencia(dataPagamento.plusDays(30 + diasExtras));
                assinatura.setStatus(true);
            } else {
                // Extensão: 30 dias + dias extras a partir da validade atual
                assinatura.setFimVigencia(assinatura.getFimVigencia().plusDays(30 + diasExtras));
                assinatura.setStatus(true);
            }

            assinaturaRepository.save(assinatura);
            pagamentoRepository.save(pagamento);

            return "Pagamento processado com sucesso! Nova validade: " + assinatura.getFimVigencia();
        } else {
            return "Pagamento recusado. Valor esperado: " + valorEsperado + ", valor recebido: " + valorPago + "\nValor estornado: " + valorEstornado;
        }
    }

    private Promocao obterPromocao(String nomePromocao) {
        return promocaoRepository.findByNome(nomePromocao);
    }
}
