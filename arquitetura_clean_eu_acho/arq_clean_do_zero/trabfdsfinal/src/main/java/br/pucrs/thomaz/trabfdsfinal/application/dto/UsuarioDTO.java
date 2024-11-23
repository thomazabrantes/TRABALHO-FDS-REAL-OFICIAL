package br.pucrs.thomaz.trabfdsfinal.application.dto;

public class UsuarioDTO {
    
    private Long codigo;
    private String usuario;
    private String senha;

    // Construtor sem parâmetros
    public UsuarioDTO() {
    }

    // Construtor que recebe todos os parâmetros
    public UsuarioDTO(Long codigo, String usuario, String senha) {
        this.codigo = codigo;
        this.usuario = usuario;
        this.senha = senha;
    }

    // Getters e Setters
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "codigo=" + codigo +
                ", usuario='" + usuario + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
