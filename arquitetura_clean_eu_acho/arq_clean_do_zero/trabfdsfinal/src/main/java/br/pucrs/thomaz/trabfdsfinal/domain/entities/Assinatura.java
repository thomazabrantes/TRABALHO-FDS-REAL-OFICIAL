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

    // Construtor público ou protegido sem parâmetros, necessário para JPA
    protected Assinatura() {
        // JPA needs a no-args constructor
    }

    private Assinatura(Aplicativo aplicativo, Cliente cliente, LocalDate inicioVigencia, LocalDate fimVigencia) {
        this.aplicativo = aplicativo;
        this.cliente = cliente;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
    }

    public static Assinatura criar(Aplicativo aplicativo, Cliente cliente, LocalDate inicioVigencia, LocalDate fimVigencia) {
        if (aplicativo == null) {
            throw new IllegalArgumentException("Aplicativo não pode ser nulo");
        }
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não pode ser nulo");
        }
        if (inicioVigencia == null) {
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
        return new Assinatura(aplicativo, cliente, inicioVigencia, fimVigencia);
    }
}