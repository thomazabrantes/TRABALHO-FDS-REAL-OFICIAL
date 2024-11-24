package br.pucrs.thomaz.trabfdsfinal.application.dto;

import java.time.LocalDate;

import br.pucrs.thomaz.trabfdsfinal.domain.entities.Aplicativo;
import br.pucrs.thomaz.trabfdsfinal.domain.entities.Cliente;

public class AssinaturaDTO {
    
    private Long codigo;
    private Aplicativo aplicativo;
    private Cliente cliente;
    private LocalDate inicioVigencia;
    private LocalDate fimVigencia;

    // Construtor sem parâmetros
    public AssinaturaDTO() {
    }

    // Construtor que recebe todos os parâmetros
    public AssinaturaDTO(Long codigo, Aplicativo aplicativo, Cliente cliente) {
        this.codigo = codigo;
        this.aplicativo = aplicativo;
        this.cliente = cliente;
        this.inicioVigencia = LocalDate.now();
        this.fimVigencia = this.inicioVigencia.plusDays(30);
    }

    // Getters e Setters
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Aplicativo getAplicativo() {
        return aplicativo;
    }

    public void setAplicativo(Aplicativo aplicativo) {
        this.aplicativo = aplicativo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
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
