package br.pucrs.thomaz.trabfdsfinal.application.usecase.Assinatura;

import org.springframework.stereotype.Service;

import br.pucrs.thomaz.trabfdsfinal.application.dto.AssinaturaDTO;
import br.pucrs.thomaz.trabfdsfinal.domain.entities.Aplicativo;
import br.pucrs.thomaz.trabfdsfinal.domain.entities.Assinatura;
import br.pucrs.thomaz.trabfdsfinal.domain.entities.Cliente;
import br.pucrs.thomaz.trabfdsfinal.domain.repository.AplicativoRepository;
import br.pucrs.thomaz.trabfdsfinal.domain.repository.AssinaturaRepository;
import br.pucrs.thomaz.trabfdsfinal.domain.repository.ClienteRepository;
import jakarta.transaction.Transactional;

@Service
public class EditarAssinaturaUseCase {
    private final AssinaturaRepository assinaturaRepository;
    private final AplicativoRepository aplicativoRepository;
    private final ClienteRepository clienteRepository;

    public EditarAssinaturaUseCase(AssinaturaRepository assinaturaRepository, AplicativoRepository aplicativoRepository, ClienteRepository clienteRepository) {
        this.assinaturaRepository = assinaturaRepository;
        this.aplicativoRepository = aplicativoRepository;
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public AssinaturaDTO execute (Long codigo, Aplicativo aplicativo, Cliente cliente) {
        Assinatura assinatura = assinaturaRepository.findById(codigo)
                                .orElseThrow(() -> new IllegalArgumentException("Assinatura não encontrada com o código: " + codigo));
        
        if (aplicativo != null && aplicativoRepository.findById(aplicativo.getCodigo()) != null) {
            assinatura.setAplicativo(aplicativo);
        } 
        
        if (cliente != null && clienteRepository.findById(cliente.getCodigo()) != null) {
            assinatura.setCliente(cliente);
        } 

        assinaturaRepository.save(assinatura);
        return new AssinaturaDTO(assinatura.getCodigo(), assinatura.getAplicativo(), assinatura.getCliente());

    }
}
