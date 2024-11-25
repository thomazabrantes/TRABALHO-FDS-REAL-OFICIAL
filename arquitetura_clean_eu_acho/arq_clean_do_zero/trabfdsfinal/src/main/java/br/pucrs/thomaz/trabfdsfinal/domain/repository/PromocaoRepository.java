package br.pucrs.thomaz.trabfdsfinal.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.pucrs.thomaz.trabfdsfinal.domain.entities.Promocao;

@Repository
public interface PromocaoRepository extends JpaRepository<Promocao, Long> {
    Promocao findByNome(String nome);
}
