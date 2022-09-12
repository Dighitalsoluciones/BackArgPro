
package com.beportfolio.hg.repository;

import com.beportfolio.hg.entity.Skills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RSkills extends JpaRepository<Skills, Integer>{
    public Optional<Skills> findByAptitudA(String aptitudA);
    public boolean existsByAptitudA(String aptitudA); 
    
}
