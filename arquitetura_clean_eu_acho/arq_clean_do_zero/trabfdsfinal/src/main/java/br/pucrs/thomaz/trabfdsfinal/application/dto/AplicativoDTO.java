package br.pucrs.thomaz.trabfdsfinal.application.dto;

public class AplicativoDTO {

    private Long codigo;
    private String nome;
    private double custoMensal;

    // Construtor sem parâmetros
    public AplicativoDTO() {
    }

    // Construtor que recebe todos os parâmetros
    public AplicativoDTO(Long codigo, String nome, double custoMensal) {
        this.codigo = codigo;
        this.nome = nome;
        this.custoMensal = custoMensal;
    }

    // Getters e Setters
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getCustoMensal() {
        return custoMensal;
    }

    public void setCustoMensal(double custoMensal) {
        this.custoMensal = custoMensal;
    }

    @Override
    public String toString() {
        return "AplicativoDTO{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", custoMensal=" + custoMensal +
                '}';
    }
}
