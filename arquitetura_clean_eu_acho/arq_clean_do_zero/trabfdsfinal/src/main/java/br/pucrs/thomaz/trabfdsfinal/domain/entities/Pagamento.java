package br.pucrs.thomaz.trabfdsfinal.domain.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Getter
@Entity
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Assinatura assinatura;

    private double valorPago;

    private LocalDate dataPagamento;

    private String promocao;

    // Construtor público ou protegido sem parâmetros, necessário para JPA
    protected Pagamento() {
        // JPA needs a no-args constructor
    }

    private Pagamento(Assinatura assinatura, double valorPago, LocalDate dataPagamento, String promocao) {
        this.assinatura = assinatura;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.promocao = promocao;
    }

    public static Pagamento criar(Assinatura assinatura, double valorPago, LocalDate dataPagamento, String promocao) {
        if(assinatura == null) {
            throw new IllegalArgumentException("Assinatura não pode ser nula");
        }
        if (valorPago <= 0) {
            throw new IllegalArgumentException("Valor não pode ser negativo");
        }
        if(dataPagamento == null){
            throw new IllegalArgumentException("Data de pagamento não pode ser nula");
        }

        LocalDate novaDataValidade;
        if (assinatura.getFimVigencia().isBefore(dataPagamento)) {
            // Assinatura vencida: reativa e adiciona 30 dias a partir da data de pagamento
            novaDataValidade = dataPagamento.plusDays(30);
        } else {
            // Assinatura ativa: estende por 30 dias a partir da data atual de validade
            novaDataValidade = assinatura.getFimVigencia().plusDays(30);
        }
        assinatura.setFimVigencia(novaDataValidade);
    
        return new Pagamento(assinatura, valorPago, dataPagamento, promocao);
    }
}