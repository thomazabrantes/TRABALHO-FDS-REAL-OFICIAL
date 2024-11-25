package br.pucrs.thomaz.trabfdsfinal.infrastructure.rest.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pucrs.thomaz.trabfdsfinal.application.dto.AssinaturaDTO;
import br.pucrs.thomaz.trabfdsfinal.application.usecase.Assinatura.CriarAssinaturaUseCase;
import br.pucrs.thomaz.trabfdsfinal.application.usecase.Assinatura.EditarAssinaturaUseCase;
import br.pucrs.thomaz.trabfdsfinal.application.usecase.Assinatura.ListarAssinaturasUseCase;

@RestController
@RequestMapping("/servcad/assinaturas")
public class AssinaturaController {
    private final CriarAssinaturaUseCase criarAssinaturaUseCase;
    private final EditarAssinaturaUseCase editarAssinaturaUseCase;
    private final ListarAssinaturasUseCase listarAssinaturasUseCase;


    public AssinaturaController(CriarAssinaturaUseCase criarAssinaturaUseCase, EditarAssinaturaUseCase editarAssinaturaUseCase, ListarAssinaturasUseCase listarAssinaturasUseCase){
        this.criarAssinaturaUseCase = criarAssinaturaUseCase;
        this.editarAssinaturaUseCase = editarAssinaturaUseCase;
        this.listarAssinaturasUseCase = listarAssinaturasUseCase;
    }

    @PostMapping
    public ResponseEntity<AssinaturaDTO> criarAssinatura (@RequestBody AssinaturaDTO assinaturaDTO) {
        try {
            AssinaturaDTO nova = criarAssinaturaUseCase.execute(assinaturaDTO.getAplicativo(), assinaturaDTO.getCliente());
            return new ResponseEntity<>(nova, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping 
    public ResponseEntity<List<AssinaturaDTO>> listarAssinaturas () {
        try {
            List<AssinaturaDTO> lista = listarAssinaturasUseCase.execute();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<AssinaturaDTO> editarAssinatura (@PathVariable Long codigo, @RequestBody AssinaturaDTO assinaturaDTO) {
        try {
            AssinaturaDTO nova = editarAssinaturaUseCase.execute(codigo, assinaturaDTO.getAplicativo(), assinaturaDTO.getCliente());
            return new ResponseEntity<>(nova, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
}
