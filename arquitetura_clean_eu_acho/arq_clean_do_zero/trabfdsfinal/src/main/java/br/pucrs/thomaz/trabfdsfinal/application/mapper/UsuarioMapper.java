package br.pucrs.thomaz.trabfdsfinal.application.mapper;

import br.pucrs.thomaz.trabfdsfinal.application.dto.UsuarioDTO;
import br.pucrs.thomaz.trabfdsfinal.domain.entities.Usuario;

public class UsuarioMapper {

    public static UsuarioDTO toDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setCodigo(usuario.getCodigo());
        dto.setUsuario(usuario.getUsuario());
        dto.setSenha(usuario.getSenha());
        return dto;
    }

    public static Usuario toEntity(UsuarioDTO dto) {
        return Usuario.criar(dto.getUsuario(), dto.getSenha());
    }
}