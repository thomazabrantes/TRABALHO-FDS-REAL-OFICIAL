package br.pucrs.thomaz.trabfdsfinal.application.dto;

public class PromocaoDTO {

    private Long id;
    private String nome;
    private int diasExtras;
    private double desconto;

    // Construtor padrão (necessário para frameworks como Jackson)
    public PromocaoDTO() {
    }

    // Construtor completo
    public PromocaoDTO(Long id, String nome, int diasExtras, double desconto) {
        this.id = id;
        this.nome = nome;
        this.diasExtras = diasExtras;
        this.desconto = desconto;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDiasExtras() {
        return diasExtras;
    }

    public void setDiasExtras(int diasExtras) {
        this.diasExtras = diasExtras;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    @Override
    public String toString() {
        return "PromocaoDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", diasExtras=" + diasExtras +
                ", desconto=" + desconto +
                '}';
    }
}
