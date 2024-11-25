package br.pucrs.thomaz.trabfdsfinal.infrastructure.rest.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.pucrs.thomaz.trabfdsfinal.application.dto.PagamentoDTO;
import br.pucrs.thomaz.trabfdsfinal.application.usecase.Pagamento.PagamentoUseCase;

@RestController
@RequestMapping("/registrarpagamento")
public class PagamentoController {

    private final PagamentoUseCase pagamentoUseCase;

    public PagamentoController(PagamentoUseCase pagamentoUseCase) {
        this.pagamentoUseCase = pagamentoUseCase;
    }

    // Endpoint para processar o pagamento
    @PostMapping("")
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
}
