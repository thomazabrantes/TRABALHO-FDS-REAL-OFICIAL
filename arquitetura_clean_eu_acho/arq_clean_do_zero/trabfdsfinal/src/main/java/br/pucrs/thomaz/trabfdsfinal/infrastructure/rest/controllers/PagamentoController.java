package br.pucrs.thomaz.trabfdsfinal.infrastructure.rest.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.pucrs.thomaz.trabfdsfinal.application.dto.PagamentoDTO;
import br.pucrs.thomaz.trabfdsfinal.application.usecase.Pagamento.ListarPagamentosUseCase;
import br.pucrs.thomaz.trabfdsfinal.application.usecase.Pagamento.PagamentoUseCase;
import br.pucrs.thomaz.trabfdsfinal.domain.entities.Pagamento;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    private final PagamentoUseCase pagamentoUseCase;
    private final ListarPagamentosUseCase listarPagamentosUseCase;

    public PagamentoController(PagamentoUseCase pagamentoUseCase, ListarPagamentosUseCase listarPagamentosUseCase) {
        this.pagamentoUseCase = pagamentoUseCase;
        this.listarPagamentosUseCase = listarPagamentosUseCase;
    }

    // Endpoint para processar o pagamento
    @PostMapping
    public ResponseEntity<String> processarPagamento(@RequestBody PagamentoDTO pagamentoDTO) {
        try {
            String resultado = pagamentoUseCase.processarPagamento(
                pagamentoDTO.getAssinatura().getCodigo(),
                pagamentoDTO.getValorPago(),
                pagamentoDTO.getPromocao()
            );
            return ResponseEntity.ok(resultado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao processar pagamento.");
        }
    }

    // Endpoint para listar todos os pagamentos
    @GetMapping
    public ResponseEntity<List<Pagamento>> listarPagamentos() {
        List<Pagamento> pagamentos = listarPagamentosUseCase.listarPagamentos();
        return ResponseEntity.ok(pagamentos);
    }
}
