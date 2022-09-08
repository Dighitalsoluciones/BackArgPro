
package com.beportfolio.hg.controller;



import com.beportfolio.hg.dto.dtoAcercaDe;
import com.beportfolio.hg.entity.AcercaDe;
import com.beportfolio.hg.security.controller.Mensaje;
import com.beportfolio.hg.service.SAcercaDe;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/acercade")
@CrossOrigin(origins = "http://localhost:4200")
public class AcercaDeController {
    
     @Autowired()
    SAcercaDe sAcercaDe;

    @GetMapping("/lista")
    public ResponseEntity<List<AcercaDe>> list() {
        List<AcercaDe> list = sAcercaDe.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<AcercaDe> geyById(@PathVariable("id") int id){
        if(!sAcercaDe.existsById(id)){
            return new ResponseEntity(new Mensaje("Id inexistente"), HttpStatus.BAD_REQUEST);
        }
        AcercaDe acercade = sAcercaDe.getOne(id).get();
        return new ResponseEntity(acercade,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sAcercaDe.existsById(id)) {
            return new ResponseEntity(new Mensaje("Id Inexistente"), HttpStatus.NOT_FOUND);
        }
        sAcercaDe.delete(id);
        return new ResponseEntity(new Mensaje("Objeto eliminado correctamente"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoAcercaDe dtoacercade) {
        if (StringUtils.isBlank(dtoacercade.getSobremi())) {
            return new ResponseEntity(new Mensaje("Campo Obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
               
        if (sAcercaDe.existBySobremi(dtoacercade.getSobremi())) {
            return new ResponseEntity(new Mensaje("Informacion ya existente"), HttpStatus.BAD_REQUEST);
        }

        AcercaDe acercade = new AcercaDe(
                dtoacercade.getSobremi());
        sAcercaDe.save(acercade);
        return new ResponseEntity(new Mensaje("Nuevo objeto creado exitosamente"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoAcercaDe dtoacercade){
        if(!sAcercaDe.existsById(id)){
            return new ResponseEntity(new Mensaje("Id inexistente"), HttpStatus.NOT_FOUND);
        }
        if(sAcercaDe.existBySobremi(dtoacercade.getSobremi()) && sAcercaDe.
                getBySobremi(dtoacercade.getSobremi()).get().getId() != id){
        return new ResponseEntity(new Mensaje("Nombre existente"), HttpStatus.BAD_REQUEST);
    }
        if(StringUtils.isBlank(dtoacercade.getSobremi())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
          
        AcercaDe acercade = sAcercaDe.getOne(id).get();
        
        acercade.setSobremi(dtoacercade.getSobremi());
      
        sAcercaDe.save(acercade);
        
        return new ResponseEntity(new Mensaje("Objeto actualizado correctamente"), HttpStatus.OK);
    }
}
