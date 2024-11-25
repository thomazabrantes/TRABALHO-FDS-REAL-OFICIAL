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
public class Assinatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private Aplicativo aplicativo;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Cliente cliente;

    private LocalDate inicioVigencia;
    private LocalDate fimVigencia;
    private boolean status;

    // Construtor público ou protegido sem parâmetros, necessário para JPA
    protected Assinatura() {
        // JPA needs a no-args constructor
    }

    private Assinatura(Aplicativo aplicativo, Cliente cliente) {
        this.aplicativo = aplicativo;
        this.cliente = cliente;
        this.inicioVigencia = LocalDate.now();
        this.fimVigencia = this.inicioVigencia.plusDays(7);
        status = true;
    }

    public Assinatura(Aplicativo aplicativo, Cliente cliente, LocalDate inicioVigencia, LocalDate fimVigencia, boolean status) {
        this.aplicativo = aplicativo;
        this.cliente = cliente;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
        this.status = status;
    }

    public static Assinatura criar(Aplicativo aplicativo, Cliente cliente) {
        if (aplicativo == null) {
            throw new IllegalArgumentException("Aplicativo não pode ser nulo");
        }
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não pode ser nulo");
        }
        return new Assinatura(aplicativo, cliente);
    }

    //Getters e Setters
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

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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

    public boolean isValida() {
        LocalDate hoje = LocalDate.now();
        return status && (hoje.isEqual(inicioVigencia) || hoje.isAfter(inicioVigencia))
               && (hoje.isBefore(fimVigencia) || hoje.isEqual(fimVigencia));
    }
}
