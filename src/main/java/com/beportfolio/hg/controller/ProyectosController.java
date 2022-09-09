
package com.beportfolio.hg.controller;


import com.beportfolio.hg.dto.dtoProyectos;
import com.beportfolio.hg.entity.Proyectos;
import com.beportfolio.hg.security.controller.Mensaje;
import com.beportfolio.hg.service.SProyectos;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/proyectos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProyectosController {
    
    @Autowired()
    SProyectos sProyectos;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list() {
        List<Proyectos> list = sProyectos.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> geyById(@PathVariable("id") int id){
        if(!sProyectos.existsById(id)){
            return new ResponseEntity(new Mensaje("Id inexistente"), HttpStatus.BAD_REQUEST);
        }
        Proyectos proyectos = sProyectos.getOne(id).get();
        return new ResponseEntity(proyectos,HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sProyectos.existsById(id)) {
            return new ResponseEntity(new Mensaje("Id Inexistente"), HttpStatus.NOT_FOUND);
        }
        sProyectos.delete(id);
        return new ResponseEntity(new Mensaje("Objeto eliminado correctamente"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyectos dtoproyectos) {
        if (StringUtils.isBlank(dtoproyectos.getLogoProyec())) {
            return new ResponseEntity(new Mensaje("Logo Obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        if (StringUtils.isBlank(dtoproyectos.getReferenciaProyec())) {
            return new ResponseEntity(new Mensaje("Referencia Obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoproyectos.getDescripcionProyec())) {
            return new ResponseEntity(new Mensaje("Descripcion obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoproyectos.getFechacreacionProyec())) {
            return new ResponseEntity(new Mensaje("Fecha de creacion obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoproyectos.getLinkProyec())) {
            return new ResponseEntity(new Mensaje("Link del proyecto obligatorio"), HttpStatus.BAD_REQUEST);
        }
   
        
        if (sProyectos.existByReferenciaProyec(dtoproyectos.getReferenciaProyec())) {
            return new ResponseEntity(new Mensaje("Referencia existente ya existente"), HttpStatus.BAD_REQUEST);
        }

        Proyectos proyectos = new Proyectos(
                dtoproyectos.getLogoProyec(), dtoproyectos.getReferenciaProyec(), dtoproyectos.getDescripcionProyec(), dtoproyectos.getFechacreacionProyec(), dtoproyectos.getLinkProyec());
        sProyectos.save(proyectos);
        return new ResponseEntity(new Mensaje("Nuevo objeto creado exitosamente"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyectos dtoproyectos){
        if(!sProyectos.existsById(id)){
            return new ResponseEntity(new Mensaje("Id inexistente"), HttpStatus.NOT_FOUND);
        }
        if(sProyectos.existByReferenciaProyec(dtoproyectos.getReferenciaProyec()) && sProyectos.
                getByReferenciaProyec(dtoproyectos.getReferenciaProyec()).get().getId() != id){
        return new ResponseEntity(new Mensaje("Proyecto existente"), HttpStatus.BAD_REQUEST);
    }
        if(StringUtils.isBlank(dtoproyectos.getLogoProyec())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoproyectos.getReferenciaProyec())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoproyectos.getDescripcionProyec())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoproyectos.getFechacreacionProyec())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoproyectos.getLinkProyec())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        
        Proyectos proyectos = sProyectos.getOne(id).get();
        
        proyectos.setLogoProyec(dtoproyectos.getLogoProyec());
        proyectos.setReferenciaProyec(dtoproyectos.getReferenciaProyec());
        proyectos.setDescripcionProyec(dtoproyectos.getDescripcionProyec());
        proyectos.setFechacreacionProyec(dtoproyectos.getFechacreacionProyec());
        proyectos.setLinkProyec(dtoproyectos.getLinkProyec());
               
        sProyectos.save(proyectos);
        
        return new ResponseEntity(new Mensaje("Objeto actualizado correctamente"), HttpStatus.OK);
    }
}
