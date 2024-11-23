package br.pucrs.thomaz.trabfdsfinal.domain.repository;

import br.pucrs.thomaz.trabfdsfinal.domain.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
