package br.pucrs.thomaz.trabfdsfinal.infrastructure.rest.controllers;

import br.pucrs.thomaz.trabfdsfinal.application.dto.AplicativoDTO;
import br.pucrs.thomaz.trabfdsfinal.application.usecase.Aplicativo.CriarAplicativoUseCase;
import br.pucrs.thomaz.trabfdsfinal.application.usecase.Aplicativo.EditarAplicativoUseCase;
import br.pucrs.thomaz.trabfdsfinal.application.usecase.Aplicativo.ListarAplicativosUseCase; // Corrigir para o nome correto
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aplicativos")
public class AplicativoController {

    private final CriarAplicativoUseCase criarAplicativoUseCase;
    private final ListarAplicativosUseCase listarAplicativosUseCase; // Usar o nome correto da classe
    private final EditarAplicativoUseCase editarAplicativoUseCase; // Incluir a injeção de dependência

    // Injeção de dependência dos casos de uso
    public AplicativoController(CriarAplicativoUseCase criarAplicativoUseCase, ListarAplicativosUseCase listarAplicativosUseCase, EditarAplicativoUseCase editarAplicativoUseCase) {
        this.criarAplicativoUseCase = criarAplicativoUseCase;
        this.listarAplicativosUseCase = listarAplicativosUseCase; // Corrigir a injeção
        this.editarAplicativoUseCase = editarAplicativoUseCase; // Incluir a injeção
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
}
