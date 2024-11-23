package br.pucrs.thomaz.trabfdsfinal.domain.repository;

import br.pucrs.thomaz.trabfdsfinal.domain.entities.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long>{
    
}
