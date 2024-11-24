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
        this.fimVigencia = this.inicioVigencia.plusDays(30);
        status = true;
    }

    public static Assinatura criar(Aplicativo aplicativo, Cliente cliente) {
        if (aplicativo == null) {
            throw new IllegalArgumentException("Aplicativo não pode ser nulo");
        }
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não pode ser nulo");
        }
        /*if (inicioVigencia == null) {
            throw new IllegalArgumentException("Data de início de vigência não pode ser nula");
        }
        if (fimVigencia == null) {
            throw new IllegalArgumentException("Data de fim de vigência não pode ser nula");
        }
        if (inicioVigencia.isAfter(fimVigencia)) {
            throw new IllegalArgumentException("Data de início de vigência não pode ser posterior à data de fim de vigência");
        }
        if (fimVigencia.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Data de fim de vigência não pode ser no passado");
        }
        */
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
}