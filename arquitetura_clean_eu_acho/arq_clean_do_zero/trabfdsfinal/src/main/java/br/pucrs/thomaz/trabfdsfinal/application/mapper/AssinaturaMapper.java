package br.pucrs.thomaz.trabfdsfinal.application.mapper;

import br.pucrs.thomaz.trabfdsfinal.application.dto.AssinaturaDTO;
import br.pucrs.thomaz.trabfdsfinal.domain.entities.Assinatura;

public class AssinaturaMapper {
    public static AssinaturaDTO toDTO(Assinatura assinatura) {
        AssinaturaDTO dto = new AssinaturaDTO();
        dto.setCodigo(assinatura.getCodigo());
        dto.setAplicativo(AplicativoMapper.toDTO(assinatura.getAplicativo()));
        dto.setCliente(ClienteMapper.toDTO(assinatura.getCliente()));
        dto.setInicioVigencia(assinatura.getInicioVigencia());
        dto.setFimVigencia(assinatura.getFimVigencia());
        return dto;
    }

    public static Assinatura toEntity(AssinaturaDTO dto) {
        return Assinatura.criar(AplicativoMapper.toEntity(dto.getAplicativo()), ClienteMapper.toEntity(dto.getCliente()), dto.getInicioVigencia(), dto.getFimVigencia());
    }
}
