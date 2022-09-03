
package com.beportfolio.hg.repository;

import com.beportfolio.hg.entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface REducacion extends JpaRepository<Educacion, Integer>{
    public Optional<Educacion> findByTitulo(String titulo);
    public boolean existsByTitulo(String titulo);
    
}
