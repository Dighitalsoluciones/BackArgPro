
package com.beportfolio.hg.service;

import com.beportfolio.hg.Interface.IPersonaService;
import com.beportfolio.hg.entity.Persona;
import com.beportfolio.hg.repository.IPersonaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpPersonaService implements IPersonaService {
    @Autowired IPersonaRepository ipersonaRepository;
    
    @Override
    public List<Persona> getPersona() {
        List<Persona> persona = ipersonaRepository.findAll();
        return persona;
    }

    @Override
    public void savePersona(Persona persona) {
     ipersonaRepository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
     ipersonaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
      Persona persona = ipersonaRepository.findById(id).orElse(null);
      return persona;
    }
    @Override
     public boolean existsById(Long id){
        return ipersonaRepository.existsById(id);
    }
    @Override
    public boolean existByNombre(String nombre){
        return ipersonaRepository.existsByNombre(nombre);
    }
    
    @Override
     public Optional<Persona> getOne(Long id){
        return ipersonaRepository.findById(id);
    }
    
     @Override
    public Optional<Persona> getByNombre(String nombre){
        return ipersonaRepository.findByNombre(nombre);
    
}
}
