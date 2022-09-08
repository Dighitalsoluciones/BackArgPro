
package com.beportfolio.hg.repository;


import com.beportfolio.hg.entity.AcercaDe;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RAcercaDe extends JpaRepository<AcercaDe, Integer>{
    public Optional<AcercaDe> findBySobremi(String sobremi);
    public boolean existsBySobremi(String sobremi);
    
}
