package br.pucrs.thomaz.trabfdsfinal.infrastructure.rest.controllers;

import br.pucrs.thomaz.trabfdsfinal.application.dto.AssinaturaDTO;
import br.pucrs.thomaz.trabfdsfinal.application.dto.ClienteDTO;
import br.pucrs.thomaz.trabfdsfinal.application.usecase.Assinatura.AssinaturaPorCliente;
import br.pucrs.thomaz.trabfdsfinal.application.usecase.Assinatura.VerificarValidade;
import br.pucrs.thomaz.trabfdsfinal.application.usecase.Cliente.CriarClienteUseCase;
import br.pucrs.thomaz.trabfdsfinal.application.usecase.Cliente.EditarClienteUseCase;
import br.pucrs.thomaz.trabfdsfinal.application.usecase.Cliente.ListarClientesUseCase; // Corrigir para o nome correto

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final CriarClienteUseCase criarClienteUseCase;
    private final ListarClientesUseCase listarClientesUseCase;
    private final EditarClienteUseCase editarClienteUseCase;
    private final AssinaturaPorCliente assinaturaPorCliente;
    private final VerificarValidade verificarValidade;


    public ClienteController(CriarClienteUseCase criarClienteUseCase, ListarClientesUseCase listarClientesUseCase, EditarClienteUseCase editarClienteUseCase, AssinaturaPorCliente assinaturaPorCliente, VerificarValidade verificarValidade) {
        this.criarClienteUseCase = criarClienteUseCase;
        this.listarClientesUseCase = listarClientesUseCase;
        this.editarClienteUseCase = editarClienteUseCase;
        this.assinaturaPorCliente = assinaturaPorCliente;
        this.verificarValidade = verificarValidade;
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> criarCliente(@RequestBody ClienteDTO clienteDTO) {
        try {
            ClienteDTO criado = criarClienteUseCase.execute(clienteDTO.getNome(), clienteDTO.getEmail());
            return new ResponseEntity<>(criado, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listarClientes() {
        try {
            List<ClienteDTO> clientes = listarClientesUseCase.execute();
            return new ResponseEntity<>(clientes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<ClienteDTO> editarCliente(@PathVariable Long codigo, @RequestBody ClienteDTO clienteDTO) {
        try {
            ClienteDTO atualizado = editarClienteUseCase.execute(codigo, clienteDTO.getNome(), clienteDTO.getEmail());
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
            List<AssinaturaDTO> assinaturas = assinaturaPorCliente.execute(id);
            return ResponseEntity.ok(assinaturas);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{clienteId}/assinaturas/{assinaturaId}/valida")
    public ResponseEntity<Boolean> verificarValidade(@PathVariable Long clienteId, @PathVariable Long assinaturaId) {
        boolean valida = verificarValidade.execute(clienteId, assinaturaId);
        return ResponseEntity.ok(valida);
    }
}
