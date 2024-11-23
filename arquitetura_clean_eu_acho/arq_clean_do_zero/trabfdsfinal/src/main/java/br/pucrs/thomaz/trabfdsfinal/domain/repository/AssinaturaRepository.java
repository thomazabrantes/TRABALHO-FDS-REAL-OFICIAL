package br.pucrs.thomaz.trabfdsfinal.domain.repository;

import br.pucrs.thomaz.trabfdsfinal.domain.entities.Assinatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssinaturaRepository extends JpaRepository<Assinatura, Long>{
    
}
