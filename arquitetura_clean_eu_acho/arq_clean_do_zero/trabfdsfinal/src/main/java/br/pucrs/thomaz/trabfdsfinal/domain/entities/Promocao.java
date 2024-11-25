package br.pucrs.thomaz.trabfdsfinal.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;


@Getter
@Entity
public class Promocao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int diasExtras; 
    private double desconto; 


    protected Promocao() {
    }

    public Promocao(String nome, int diasExtras, double desconto) {
        if (diasExtras < 0 && desconto < 0) {
            throw new IllegalArgumentException("A promoção deve oferecer dias extras ou desconto.");
        }
        this.nome = nome;
        this.diasExtras = diasExtras;
        this.desconto = desconto;

    }
}
