package br.pucrs.thomaz.trabfdsfinal.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class Usuario {
    
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long codigo;
    
        private String usuario;
        private String senha;
    
        // Construtor público ou protegido sem parâmetros, necessário para JPA
        protected Usuario() {
            // JPA needs a no-args constructor
        }
    
        private Usuario(String usuario, String senha) {
            this.usuario = usuario;
            this.senha = senha;
        }
    
        public static Usuario criar(String usuario, String senha) {
            if (usuario == null || usuario.trim().isEmpty()) {
                throw new IllegalArgumentException("Usuário não pode ser vazio");
            }
            if (senha == null || senha.trim().isEmpty()) {
                throw new IllegalArgumentException("Senha não pode ser vazia");
            }
            return new Usuario(usuario, senha);
        }
}