
package com.beportfolio.hg.controller;

import com.beportfolio.hg.dto.dtoExperiencia;
import com.beportfolio.hg.entity.Experiencia;
import com.beportfolio.hg.security.controller.Mensaje;
import com.beportfolio.hg.service.SExperiencia;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("explab")
@CrossOrigin(origins = "http://localhost:4200")
public class CExperiencia {
    @Autowired
    SExperiencia sExperiencia;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list(){
       List<Experiencia> list = sExperiencia.list(); 
       return new ResponseEntity(list, HttpStatus.OK);
        
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoexp){
        if(StringUtils.isBlank(dtoexp.getNombreExp()))
            return new ResponseEntity(new Mensaje("Nombre obligatorio"), HttpStatus.BAD_REQUEST);
        if(sExperiencia.existsByNombreExp(dtoexp.getNombreExp()))
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = new Experiencia(dtoexp.getNombreExp(), dtoexp.getDescripcionExp());
        sExperiencia.save(experiencia);
        
        return new ResponseEntity(new Mensaje("Nueva experiencia agregada"), HttpStatus.OK);
        
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperiencia dtoexp){
        if(!sExperiencia.existsById(id))
            return new ResponseEntity(new Mensaje("Id inexistente"), HttpStatus.BAD_REQUEST);
        
        if(sExperiencia.existsByNombreExp(dtoexp.getNombreExp()) && sExperiencia.getByNombreExp(dtoexp.getNombreExp()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Experiencia ya existente"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoexp.getNombreExp()))
            return new ResponseEntity(new Mensaje("Nombre obligatorio"), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = sExperiencia.getOne(id).get();
        experiencia.setNombreExp(dtoexp.getNombreExp());
        experiencia.setDescripcionExp((dtoexp.getDescripcionExp()));
        
        sExperiencia.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada correctamente"), HttpStatus.OK);
    }
    
   public ResponseEntity<?> delete(@PathVariable("id") int id){
       if(!sExperiencia.existsById(id))
           return new ResponseEntity(new Mensaje("Id inexistente"), HttpStatus.BAD_REQUEST);
       
       sExperiencia.delete(id);
       
       return new ResponseEntity(new Mensaje("La experiencia ha sido eliminada correctamente"), HttpStatus.OK);
   }
}
