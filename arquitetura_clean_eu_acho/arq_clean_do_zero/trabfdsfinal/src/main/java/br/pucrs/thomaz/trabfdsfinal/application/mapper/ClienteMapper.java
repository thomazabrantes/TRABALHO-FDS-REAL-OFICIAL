package br.pucrs.thomaz.trabfdsfinal.application.mapper;

import br.pucrs.thomaz.trabfdsfinal.application.dto.ClienteDTO;
import br.pucrs.thomaz.trabfdsfinal.domain.entities.Cliente;

public class ClienteMapper {

    public static ClienteDTO toDTO(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();
        dto.setCodigo(cliente.getCodigo());
        dto.setNome(cliente.getNome());
        dto.setEmail(cliente.getEmail());
        return dto;
    }

    public static Cliente toEntity(ClienteDTO dto) {
        return Cliente.criar(dto.getNome(), dto.getEmail());
    }
}