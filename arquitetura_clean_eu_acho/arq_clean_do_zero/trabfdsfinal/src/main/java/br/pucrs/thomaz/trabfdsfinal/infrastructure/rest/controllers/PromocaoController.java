package br.pucrs.thomaz.trabfdsfinal.infrastructure.rest.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pucrs.thomaz.trabfdsfinal.application.usecase.Pagamento.ListarPromocoesUseCase;
import br.pucrs.thomaz.trabfdsfinal.domain.entities.Promocao;

@RestController
@RequestMapping("/servcad/promocoes")
public class PromocaoController {
    
    private final ListarPromocoesUseCase listarPromocoesUseCase;

    public PromocaoController(ListarPromocoesUseCase listarPromocoesUseCase) {
        this.listarPromocoesUseCase = listarPromocoesUseCase;
    }

    // Endpoint para listar todas as promoções
    @GetMapping
    public ResponseEntity<List<Promocao>> listarPromocoes() {
        List<Promocao> pagamentos = listarPromocoesUseCase.listarPromocoes();
        return ResponseEntity.ok(pagamentos);
    }
}
