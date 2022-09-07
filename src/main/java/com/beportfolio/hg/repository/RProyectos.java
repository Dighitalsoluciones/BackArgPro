
package com.beportfolio.hg.repository;


import com.beportfolio.hg.entity.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RProyectos extends JpaRepository<Proyectos, Integer>{
    public Optional<Proyectos> findByReferenciaProyec(String referenciaProyec);
    public boolean existsByReferenciaProyec(String referenciaProyec);
    
}
