
package com.beportfolio.hg.service;


import com.beportfolio.hg.entity.Proyectos;
import com.beportfolio.hg.repository.RProyectos;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SProyectos {
     @Autowired
    RProyectos rProyectos;
    
    public List<Proyectos> list(){
        return rProyectos.findAll();
    }
 
    public Optional<Proyectos> getOne(int id){
        return rProyectos.findById(id);
    }
    
    public Optional<Proyectos> getByReferenciaProyec(String referenciaProyec){
        return rProyectos.findByReferenciaProyec(referenciaProyec);
    }
    
    public void save(Proyectos proyectos){
        rProyectos.save(proyectos);
    }
    
    public void delete(int id){
        rProyectos.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rProyectos.existsById(id);
    }
    
    public boolean existByReferenciaProyec(String referenciaProyec){
        return rProyectos.existsByReferenciaProyec(referenciaProyec);
    }
}
