package br.pucrs.thomaz.trabfdsfinal.application.dto;

import java.time.LocalDate;

public class PagamentoDTO {
    
    private Long codigo;
    private AssinaturaDTO assinatura;
    private double valorPago;
    private LocalDate dataPagamento;
    private String promocao;

    // Construtor sem parâmetros
    public PagamentoDTO() {
    }

    // Construtor que recebe todos os parâmetros
    public PagamentoDTO(Long codigo, AssinaturaDTO assinatura, double valorPago, LocalDate dataPagamento, String promocao) {
        this.codigo = codigo;
        this.assinatura = assinatura;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.promocao = promocao;
    }

    // Getters e Setters
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public AssinaturaDTO getAssinatura() {
        return assinatura;
    }

    public void setAssinatura(AssinaturaDTO assinatura) {
        this.assinatura = assinatura;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getPromocao() {
        return promocao;
    }

    public void setPromocao(String promocao) {
        this.promocao = promocao;
    }

    @Override
    public String toString() {
        return "PagamentoDTO{" +
                "codigo=" + codigo +
                ", assinatura=" + assinatura +
                ", valorPago=" + valorPago +
                ", dataPagamento=" + dataPagamento +
                ", promocao='" + promocao + '\'' +
                '}';
    }
}
