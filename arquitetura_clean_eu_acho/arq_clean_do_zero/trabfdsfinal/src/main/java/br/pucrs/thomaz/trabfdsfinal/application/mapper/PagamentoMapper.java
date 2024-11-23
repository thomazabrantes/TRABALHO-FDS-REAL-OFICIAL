package br.pucrs.thomaz.trabfdsfinal.application.mapper;

import br.pucrs.thomaz.trabfdsfinal.application.dto.PagamentoDTO;
import br.pucrs.thomaz.trabfdsfinal.domain.entities.Pagamento;

public class PagamentoMapper {

    public static PagamentoDTO toDTO(Pagamento pagamento) {
        PagamentoDTO dto = new PagamentoDTO();
        dto.setCodigo(pagamento.getCodigo());
        dto.setAssinatura(AssinaturaMapper.toDTO(pagamento.getAssinatura()));
        dto.setValorPago(pagamento.getValorPago());
        dto.setDataPagamento(pagamento.getDataPagamento());
        dto.setPromocao(pagamento.getPromocao());
        return dto;
    }

    public static Pagamento toEntity(PagamentoDTO dto) {
        return Pagamento.criar(AssinaturaMapper.toEntity(dto.getAssinatura()), dto.getValorPago(), dto.getDataPagamento(), dto.getPromocao());
    }
}