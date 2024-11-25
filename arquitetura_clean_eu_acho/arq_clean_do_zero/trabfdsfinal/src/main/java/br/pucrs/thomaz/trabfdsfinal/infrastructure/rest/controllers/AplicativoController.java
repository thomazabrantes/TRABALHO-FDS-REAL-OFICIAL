package br.pucrs.thomaz.trabfdsfinal.infrastructure.rest.controllers;

import br.pucrs.thomaz.trabfdsfinal.application.dto.AplicativoDTO;
import br.pucrs.thomaz.trabfdsfinal.application.dto.AssinaturaDTO;
import br.pucrs.thomaz.trabfdsfinal.application.usecase.Aplicativo.CriarAplicativoUseCase;
import br.pucrs.thomaz.trabfdsfinal.application.usecase.Aplicativo.EditarAplicativoUseCase;
import br.pucrs.thomaz.trabfdsfinal.application.usecase.Aplicativo.ListarAplicativosUseCase; // Corrigir para o nome correto
import br.pucrs.thomaz.trabfdsfinal.application.usecase.Assinatura.AssinaturaPorAplicativo;
import br.pucrs.thomaz.trabfdsfinal.application.usecase.Assinatura.VerificarValidade;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servcad/aplicativos")
public class AplicativoController {

    private final CriarAplicativoUseCase criarAplicativoUseCase;
    private final ListarAplicativosUseCase listarAplicativosUseCase; 
    private final EditarAplicativoUseCase editarAplicativoUseCase; 
    private final AssinaturaPorAplicativo assinaturaPorAplicativo;
    private final VerificarValidade verificarValidade;

    // Injeção de dependência dos casos de uso
    public AplicativoController(CriarAplicativoUseCase criarAplicativoUseCase, ListarAplicativosUseCase listarAplicativosUseCase, EditarAplicativoUseCase editarAplicativoUseCase, AssinaturaPorAplicativo assinaturaPorAplicativo, VerificarValidade verificarValidade) {
        this.criarAplicativoUseCase = criarAplicativoUseCase;
        this.listarAplicativosUseCase = listarAplicativosUseCase; // Corrigir a injeção
        this.editarAplicativoUseCase = editarAplicativoUseCase; // Incluir a injeção
        this.assinaturaPorAplicativo = assinaturaPorAplicativo;
        this.verificarValidade = verificarValidade;

    }

    // Endpoint para criar um aplicativo
    @PostMapping
    public ResponseEntity<AplicativoDTO> criarAplicativo(@RequestBody AplicativoDTO aplicativoDTO) {
        try {
            AplicativoDTO criado = criarAplicativoUseCase.execute(aplicativoDTO.getNome(), aplicativoDTO.getCustoMensal());
            return new ResponseEntity<>(criado, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Endpoint para listar todos os aplicativos
    @GetMapping
    public ResponseEntity<List<AplicativoDTO>> listarAplicativos() {
        try {
            List<AplicativoDTO> aplicativos = listarAplicativosUseCase.execute();
            return new ResponseEntity<>(aplicativos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint para editar um aplicativo
    @PutMapping("/{codigo}")
    public ResponseEntity<AplicativoDTO> editarAplicativo(@PathVariable Long codigo, @RequestBody AplicativoDTO aplicativoDTO) {
        try {
            AplicativoDTO atualizado = editarAplicativoUseCase.execute(codigo, aplicativoDTO.getNome(), aplicativoDTO.getCustoMensal());
            return new ResponseEntity<>(atualizado, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

     @GetMapping("/{id}/assinaturas")
    public ResponseEntity<List<AssinaturaDTO>> listarAssinaturas(@PathVariable Long id) {
        try {
            List<AssinaturaDTO> assinaturas = assinaturaPorAplicativo.execute(id);
            return ResponseEntity.ok(assinaturas);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{aplicativoId}/assinaturas/{assinaturaId}/valida")
    public ResponseEntity<Boolean> verificarValidade(@PathVariable Long aplicativoId, @PathVariable Long assinaturaId) {
        boolean valida = verificarValidade.execute(aplicativoId, assinaturaId);
        return ResponseEntity.ok(valida);
    
    }
}
