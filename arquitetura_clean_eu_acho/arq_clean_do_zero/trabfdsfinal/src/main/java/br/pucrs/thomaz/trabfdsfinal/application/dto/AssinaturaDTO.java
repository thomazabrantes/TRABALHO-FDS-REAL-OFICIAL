package br.pucrs.thomaz.trabfdsfinal.application.dto;

import java.time.LocalDate;

public class AssinaturaDTO {
    
    private Long codigo;
    private AplicativoDTO aplicativo;
    private ClienteDTO cliente;
    private LocalDate inicioVigencia;
    private LocalDate fimVigencia;

    // Construtor sem parâmetros
    public AssinaturaDTO() {
    }

    // Construtor que recebe todos os parâmetros
    public AssinaturaDTO(Long codigo, AplicativoDTO aplicativo, ClienteDTO cliente, LocalDate inicioVigencia, LocalDate fimVigencia) {
        this.codigo = codigo;
        this.aplicativo = aplicativo;
        this.cliente = cliente;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
    }

    // Getters e Setters
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public AplicativoDTO getAplicativo() {
        return aplicativo;
    }

    public void setAplicativo(AplicativoDTO aplicativo) {
        this.aplicativo = aplicativo;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public LocalDate getInicioVigencia() {
        return inicioVigencia;
    }

    public void setInicioVigencia(LocalDate inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }

    public LocalDate getFimVigencia() {
        return fimVigencia;
    }

    public void setFimVigencia(LocalDate fimVigencia) {
        this.fimVigencia = fimVigencia;
    }

    @Override
    public String toString() {
        return "AssinaturaDTO{" +
                "codigo=" + codigo +
                ", aplicativo=" + aplicativo +
                ", cliente=" + cliente +
                ", inicioVigencia=" + inicioVigencia +
                ", fimVigencia=" + fimVigencia +
                '}';
    }
}
