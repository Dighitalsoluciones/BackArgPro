package com.beportfolio.hg.controller;

import com.beportfolio.hg.dto.dtoEducacion;
import com.beportfolio.hg.entity.Educacion;
import com.beportfolio.hg.security.controller.Mensaje;
import com.beportfolio.hg.service.SEducacion;
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
@RequestMapping("/educacion")
@CrossOrigin(origins = "http://localhost:4200")
public class EducacionController {

    @Autowired()
    SEducacion sEducacion;

    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list() {
        List<Educacion> list = sEducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> geyById(@PathVariable("id") int id){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("Id inexistente"), HttpStatus.BAD_REQUEST);
        }
        Educacion educacion = sEducacion.getOne(id).get();
        return new ResponseEntity(educacion,HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("Id Inexistente"), HttpStatus.NOT_FOUND);
        }
        sEducacion.delete(id);
        return new ResponseEntity(new Mensaje("Objeto eliminado correctamente"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoeducacion) {
        if (StringUtils.isBlank(dtoeducacion.getLogo())) {
            return new ResponseEntity(new Mensaje("Logo Obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        if (StringUtils.isBlank(dtoeducacion.getTitulo())) {
            return new ResponseEntity(new Mensaje("Titulo Obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoeducacion.getCentroeduc())) {
            return new ResponseEntity(new Mensaje("Nombre del centro educativo obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoeducacion.getDesde())) {
            return new ResponseEntity(new Mensaje("Fecha de comienzo obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoeducacion.getHasta())) {
            return new ResponseEntity(new Mensaje("Fecha de finalizacion obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoeducacion.getUbicacion())) {
            return new ResponseEntity(new Mensaje("Ubicacion del centro educativo obligatorio"), HttpStatus.BAD_REQUEST);

        }
        if (sEducacion.existByTitulo(dtoeducacion.getTitulo())) {
            return new ResponseEntity(new Mensaje("Titulo ya existente"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = new Educacion(
                dtoeducacion.getLogo(), dtoeducacion.getTitulo(), dtoeducacion.getCentroeduc(), dtoeducacion.getDesde(), dtoeducacion.getHasta(),
                dtoeducacion.getUbicacion());
        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Nuevo objeto creado exitosamente"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoeducacion){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("Id inexistente"), HttpStatus.NOT_FOUND);
        }
        if(sEducacion.existByTitulo(dtoeducacion.getTitulo()) && sEducacion.
                getByTitulo(dtoeducacion.getTitulo()).get().getId() != id){
        return new ResponseEntity(new Mensaje("Nombre existente"), HttpStatus.BAD_REQUEST);
    }
        if(StringUtils.isBlank(dtoeducacion.getLogo())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoeducacion.getTitulo())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoeducacion.getCentroeduc())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoeducacion.getDesde())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoeducacion.getHasta())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoeducacion.getUbicacion())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = sEducacion.getOne(id).get();
        
        educacion.setLogo(dtoeducacion.getLogo());
        educacion.setTitulo(dtoeducacion.getTitulo());
        educacion.setCentroeduc(dtoeducacion.getCentroeduc());
        educacion.setDesde(dtoeducacion.getDesde());
        educacion.setHasta(dtoeducacion.getHasta());
        educacion.setUbicacion(dtoeducacion.getUbicacion());
        
        sEducacion.save(educacion);
        
        return new ResponseEntity(new Mensaje("Objeto actualizado correctamente"), HttpStatus.OK);
    }
}
