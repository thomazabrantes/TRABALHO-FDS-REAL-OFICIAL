package br.pucrs.thomaz.trabfdsfinal.domain.repository;

import br.pucrs.thomaz.trabfdsfinal.domain.entities.Aplicativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AplicativoRepository extends JpaRepository<Aplicativo, Long> {
    // Você pode adicionar métodos personalizados aqui, se necessário, por exemplo:
    // Optional<Aplicativo> findByNome(String nome);
}
