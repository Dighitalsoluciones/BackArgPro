package com.beportfolio.hg.Interface;

import com.beportfolio.hg.entity.Persona;
import java.util.List;
import java.util.Optional;

public interface IPersonaService {
    public List<Persona> getPersona();
    
    public void savePersona(Persona persona);
    
    public void deletePersona(Long id);
    
    public Persona findPersona(Long id);
    
    public boolean existsById(Long id);
    
    public boolean existByNombre(String nombre);
    
    public Optional<Persona> getOne(Long id);
       
    
    public Optional<Persona> getByNombre(String nombre);
        
}
