package br.pucrs.thomaz.trabfdsfinal.application.usecase.Aplicativo;

import br.pucrs.thomaz.trabfdsfinal.application.dto.AplicativoDTO;
import br.pucrs.thomaz.trabfdsfinal.domain.entities.Aplicativo;
import br.pucrs.thomaz.trabfdsfinal.domain.repository.AplicativoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EditarAplicativoUseCase {

    private final AplicativoRepository aplicativoRepository;

    public EditarAplicativoUseCase(AplicativoRepository aplicativoRepository) {
        this.aplicativoRepository = aplicativoRepository;
    }

    @Transactional
    public AplicativoDTO execute(Long codigo, String novoNome, double novoCustoMensal) {
        // Busca o aplicativo pelo código
        Aplicativo aplicativo = aplicativoRepository.findById(codigo)
                .orElseThrow(() -> new IllegalArgumentException("Aplicativo não encontrado com o código: " + codigo));

        // Atualiza os valores
        if (novoNome != null && !novoNome.trim().isEmpty()) {
            aplicativo.setNome(novoNome);
        }
        if (novoCustoMensal >= 0) {
            aplicativo.setCustoMensal(novoCustoMensal);
        } else {
            throw new IllegalArgumentException("O custo mensal não pode ser negativo.");
        }

        // Salva as alterações
        aplicativo = aplicativoRepository.save(aplicativo);

        // Retorna o DTO atualizado
        return new AplicativoDTO(aplicativo.getCodigo(), aplicativo.getNome(), aplicativo.getCustoMensal());
    }
}
