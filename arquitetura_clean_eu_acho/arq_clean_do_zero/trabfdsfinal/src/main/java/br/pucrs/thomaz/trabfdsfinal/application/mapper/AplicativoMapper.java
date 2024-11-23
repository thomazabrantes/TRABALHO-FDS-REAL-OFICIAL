package br.pucrs.thomaz.trabfdsfinal.application.mapper;

import br.pucrs.thomaz.trabfdsfinal.domain.entities.Aplicativo;
import br.pucrs.thomaz.trabfdsfinal.application.dto.AplicativoDTO;

public class AplicativoMapper {

    public static AplicativoDTO toDTO(Aplicativo aplicativo) {
        AplicativoDTO dto = new AplicativoDTO();
        dto.setCodigo(aplicativo.getCodigo());
        dto.setNome(aplicativo.getNome());
        dto.setCustoMensal(aplicativo.getCustoMensal());
        return dto;
    }

    public static Aplicativo toEntity(AplicativoDTO dto) {
        return Aplicativo.criar(dto.getNome(), dto.getCustoMensal());
    }
}

