
package com.beportfolio.hg.service;


import com.beportfolio.hg.entity.AcercaDe;
import com.beportfolio.hg.repository.RAcercaDe;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SAcercaDe {
    @Autowired
    RAcercaDe rAcercaDe;
    
    public List<AcercaDe> list(){
        return rAcercaDe.findAll();
    }
 
    public Optional<AcercaDe> getOne(int id){
        return rAcercaDe.findById(id);
    }
    
    public Optional<AcercaDe> getBySobremi(String sobremi){
        return rAcercaDe.findBySobremi(sobremi);
    }
    
    public void save(AcercaDe acercade){
        rAcercaDe.save(acercade);
    }
    
    public void delete(int id){
        rAcercaDe.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rAcercaDe.existsById(id);
    }
    
    public boolean existBySobremi(String sobremi){
        return rAcercaDe.existsBySobremi(sobremi);
    }
}
