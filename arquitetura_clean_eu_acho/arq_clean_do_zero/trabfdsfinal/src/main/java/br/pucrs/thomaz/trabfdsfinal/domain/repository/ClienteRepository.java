package br.pucrs.thomaz.trabfdsfinal.domain.repository;

import br.pucrs.thomaz.trabfdsfinal.domain.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
}
