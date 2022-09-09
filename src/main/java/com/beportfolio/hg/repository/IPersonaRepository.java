
package com.beportfolio.hg.repository;

import com.beportfolio.hg.entity.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Long> {
      public Optional<Persona> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
    
}
