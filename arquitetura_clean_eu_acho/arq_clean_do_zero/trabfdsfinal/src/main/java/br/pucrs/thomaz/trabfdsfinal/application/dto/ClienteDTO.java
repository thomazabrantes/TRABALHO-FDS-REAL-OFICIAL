package br.pucrs.thomaz.trabfdsfinal.application.dto;

public class ClienteDTO {

    private Long codigo;
    private String nome;
    private String email;

    // Construtor sem parâmetros
    public ClienteDTO() {
    }

    // Construtor que recebe todos os parâmetros
    public ClienteDTO(Long codigo, String nome, String email) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ClienteDTO{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
