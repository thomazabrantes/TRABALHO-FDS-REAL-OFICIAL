package br.pucrs.thomaz.trabfdsfinal.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class Aplicativo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String nome;
    private double custoMensal;

    // Construtor público ou protegido sem parâmetros, necessário para JPA
    protected Aplicativo() {
        // JPA needs a no-args constructor
    }

    private Aplicativo(String nome, double custoMensal) {
        this.nome = nome;
        this.custoMensal = custoMensal;
    }

    public static Aplicativo criar(String nome, double custoMensal) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        if (custoMensal < 0) {
            throw new IllegalArgumentException("Custo mensal não pode ser negativo");
        }
        return new Aplicativo(nome, custoMensal);
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        this.nome = nome;
    }

    public void setCustoMensal(double custoMensal) {
        if (custoMensal < 0) {
            throw new IllegalArgumentException("Custo mensal não pode ser negativo");
        }
        this.custoMensal = custoMensal;
    }
}
