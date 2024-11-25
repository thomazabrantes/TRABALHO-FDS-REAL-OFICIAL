package br.pucrs.thomaz.trabfdsfinal.domain.repository;

import br.pucrs.thomaz.trabfdsfinal.domain.entities.Aplicativo;
import br.pucrs.thomaz.trabfdsfinal.domain.entities.Assinatura;
import br.pucrs.thomaz.trabfdsfinal.domain.entities.Cliente;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssinaturaRepository extends JpaRepository<Assinatura, Long>{

    List<Assinatura> findByCliente(Cliente cliente);
    List<Assinatura> findByAplicativo(Aplicativo aplicativo);
    Optional<Assinatura> findByClienteCodigoAndCodigo(Long clienteCodigo, Long assinaturaCodigo);
}
